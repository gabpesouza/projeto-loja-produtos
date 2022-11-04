package br.com.fiap.store.model.DAO;

import br.com.fiap.store.model.DAO.impl.ProdutoDAOJDBC;

public class DAOFactory {
	
	public static ProdutoDAO createProdutoDAO() {
		
		return new ProdutoDAOJDBC();
	}

}
