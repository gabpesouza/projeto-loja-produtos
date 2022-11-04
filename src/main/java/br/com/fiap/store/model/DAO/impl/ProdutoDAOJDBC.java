package br.com.fiap.store.model.DAO.impl;

import java.sql.Connection;
import java.util.List;

import br.com.fiap.store.model.Produto;
import br.com.fiap.store.model.DAO.ProdutoDAO;

public class ProdutoDAOJDBC implements ProdutoDAO {

	private Connection con;
	
	public ProdutoDAOJDBC(Connection con) {
		this.con = con;
	}
	
	
	@Override
	public void cadastrar(Produto produto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Produto produto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(int codigo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Produto buscar(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produto> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
