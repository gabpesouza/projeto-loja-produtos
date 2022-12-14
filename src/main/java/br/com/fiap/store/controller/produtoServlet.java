package br.com.fiap.store.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.store.model.Categoria;
import br.com.fiap.store.model.Produto;
import br.com.fiap.store.model.DAO.CategoriaDAO;
import br.com.fiap.store.model.DAO.DAOFactory;
import br.com.fiap.store.model.DAO.ProdutoDAO;


@WebServlet("/produto")
public class produtoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProdutoDAO dao;
	private CategoriaDAO catDAO;
	
	
    
 
    public produtoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	super.init();
    	dao = DAOFactory.createProdutoDAO();
    	catDAO = DAOFactory.createCategoriaDAO();
    }
 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String acao = req.getParameter("acao");
		
		switch (acao) {
		case "listar": 
			listar(req, resp);
			break;
		case "editar":
			List<Categoria> categorias = catDAO.listar();
			int codigo = Integer.parseInt(req.getParameter("codigo"));
			Produto produto = dao.buscar(codigo);
			req.setAttribute("produto", produto);
			req.setAttribute("categorias", categorias);
			req.getRequestDispatcher("alterarProduto.jsp").forward(req, resp);
			break;
		case "abrir-form-cadastro":
			abrirFormCadastro(req,resp);
		}
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		
		switch(acao) {
		case "editar":
			editar(request, response);
			break;
		case "cadastrar":
			cadastrar(request, response);
			break;
		case "remover":
			int id = Integer.parseInt(request.getParameter("codigo"));
			dao.remover(id);
			request.setAttribute("msgRemocao", "Produto removido");
			listar(request, response);
			break;
		}
		
		
	}

	private void cadastrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
	try {
		String nome = request.getParameter("nome");
		double valor = Double.parseDouble(request.getParameter("valor"));
		String data = request.getParameter("data");
		int quantidade = Integer.parseInt(request.getParameter("quantidade"));
		int catCodigo = Integer.parseInt(request.getParameter("categoria"));
		Date date = null;
		date = sdf.parse(data);
		
		
		Categoria cat = new Categoria();
		cat.setCodigo(catCodigo);
		Produto produto = new Produto(0,nome,valor,date,quantidade);
		produto.setCategoria(cat);
			
		dao.cadastrar(produto);
		request.setAttribute("msg", "Produto cadastrado!");
		}
		catch (Exception e) {
			e.printStackTrace();
		request.setAttribute("error", "Por favor valide os dados");
		}
		
		abrirFormCadastro(request, response);
	}
	
	private void editar (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			int codigo = Integer.parseInt(request.getParameter("codigo"));
			String nome = request.getParameter("nome");
			double valor = Double.parseDouble(request.getParameter("valor"));
			String data = request.getParameter("data");
			int quantidade = Integer.parseInt(request.getParameter("quantidade"));
			int catCodigo = Integer.parseInt(request.getParameter("categoria"));
			Date date = null;
			date = sdf.parse(data);
			
			Categoria cat = new Categoria();
			cat.setCodigo(catCodigo);
			
			Produto produto = new Produto(codigo,nome,valor,date,quantidade);
			produto.setCategoria(cat);
			
			dao.atualizar(produto);
			request.setAttribute("msg", "produto atualizado");
	}
		catch (Exception e) {
			e.getMessage();
			request.setAttribute("error", "Insira dados validos");
		}
		
		listar(request,response);

}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Produto> lista = dao.listar();
		request.setAttribute("produtos", lista);
		
		request.getRequestDispatcher("lista-produto.jsp").forward(request, response);
		
	}
	
	private void abrirFormCadastro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Categoria> categorias = catDAO.listar();
		req.setAttribute("categorias", categorias);
		req.getRequestDispatcher("cadastro-produto.jsp").forward(req, resp);
		
	}

	
	
	
	
	
	
}