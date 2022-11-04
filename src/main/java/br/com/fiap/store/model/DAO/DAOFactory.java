package br.com.fiap.store.model.DAO;

import br.com.fiap.store.model.DAO.impl.ProdutoDAOJDBC;
import br.com.fiap.store.model.DB.DB;

public class DAOFactory {
	
	public static ProdutoDAO createProdutoDAO() throws ClassNotFoundException {
		
		return new ProdutoDAOJDBC(DB.getConnection());
	}

}
