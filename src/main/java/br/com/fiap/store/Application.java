package br.com.fiap.store;

import java.util.List;

import br.com.fiap.store.model.Produto;
import br.com.fiap.store.model.DAO.DAOFactory;
import br.com.fiap.store.model.DAO.ProdutoDAO;

public class Application {
		
	public static void main(String[] args) throws ClassNotFoundException {
		
		ProdutoDAO dao = DAOFactory.createProdutoDAO();
//		Produto produto = new Produto(0, "Computador",8000 , new Date(), 1);
//		dao.cadastrar(produto);
		
//		Produto produtoBuscado = dao.buscar(1);
//		System.out.println(produtoBuscado);
		
		List<Produto> lista = dao.listar();
		for (Produto produto : lista) {
			System.out.println(produto);
		}
	}
}
