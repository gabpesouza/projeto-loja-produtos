package br.com.fiap.store.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.store.model.Produto;
import br.com.fiap.store.model.DAO.DAOFactory;
import br.com.fiap.store.model.DAO.ProdutoDAO;


@WebServlet("/produto")
public class produtoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProdutoDAO dao;
	
	
    
 
    public produtoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	super.init();
    	dao = DAOFactory.createProdutoDAO();
    }
 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Produto> lista = dao.listar();
		req.setAttribute("produtos", lista);
		
		req.getRequestDispatcher("lista-produto.jsp").forward(req, resp);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
	try {
		String nome = request.getParameter("nome");
		double valor = Double.parseDouble(request.getParameter("valor"));
		String data = request.getParameter("data");
		int quantidade = Integer.parseInt(request.getParameter("quantidade"));
		Date date = null;
	
		date = sdf.parse(data);
		
		Produto produto = new Produto(0,nome,valor,date,quantidade);
		
			
		dao.cadastrar(produto);
		request.setAttribute("msg", "Produto cadastrado!");
		}
		catch (Exception e) {
			e.printStackTrace();
		request.setAttribute("error", "Por favor valide os dados");
		}
		
		request.getRequestDispatcher("cadastro-produto.jsp").forward(request, response);
	}

}
