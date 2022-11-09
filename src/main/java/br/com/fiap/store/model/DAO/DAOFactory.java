package br.com.fiap.store.model.DAO;

import br.com.fiap.store.model.DAO.impl.CategoriaDAOJDBC;
import br.com.fiap.store.model.DAO.impl.ProdutoDAOJDBC;
import br.com.fiap.store.model.DAO.impl.UsuarioDAOJDBC;

public class DAOFactory {
	
	public static ProdutoDAO createProdutoDAO() {
		
		return new ProdutoDAOJDBC();
	}
	
	public static CategoriaDAO createCategoriaDAO() {
		
		return new CategoriaDAOJDBC();
	}
	
	public static UsuarioDAO createUsuarioDAO() {
		
		return new UsuarioDAOJDBC();
	}

}
