package br.com.fiap.store;

import java.util.List;

import br.com.fiap.store.model.Categoria;
import br.com.fiap.store.model.DAO.CategoriaDAO;
import br.com.fiap.store.model.DAO.DAOFactory;
import br.com.fiap.store.model.DAO.ProdutoDAO;
import br.com.fiap.store.util.CriptografiaUtils;

public class Application {
		
	public static void main(String[] args) throws Exception {
		
		ProdutoDAO dao = DAOFactory.createProdutoDAO();
//		Produto produto = new Produto(1, "PS5",5000 , new Date(), 1);
//		dao.cadastrar(produto);
		
//		Produto produtoBuscado = dao.buscar(1);
//		System.out.println(produtoBuscado);
		
//		List<Produto> lista = dao.listar();
//		for (Produto produto : lista) {
//			System.out.println(produto);
//		}
//		
//		Produto produtoBuscado = dao.buscar(1);
//		System.out.println(produtoBuscado);
		
//		dao.atualizar(produto);
//		dao.remover(produto.getCodigo());
		
//		CategoriaDAO cat = DAOFactory.createCategoriaDAO();
//		List<Categoria> listaCategoria = cat.listar();
//	
//		for (Categoria categoria : listaCategoria) {
//			System.out.println(categoria);
//		}
		
		System.out.println(CriptografiaUtils.criptografar("123456"));
		
	}
}
