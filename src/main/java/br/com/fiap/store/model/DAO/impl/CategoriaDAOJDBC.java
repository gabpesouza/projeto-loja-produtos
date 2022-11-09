package br.com.fiap.store.model.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.store.model.Categoria;
import br.com.fiap.store.model.DAO.CategoriaDAO;
import br.com.fiap.store.model.DB.ConnectionManager;
import br.com.fiap.store.model.DB.exceptions.DbException;

public class CategoriaDAOJDBC implements CategoriaDAO {

	private Connection con;
	
	@Override
	public List<Categoria> listar() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Categoria> cat = new ArrayList<Categoria>();
		
		try {
			con = ConnectionManager.getInstance().getConnection();
			ps = con.prepareStatement("SELECT * FROM TB_CATEGORIA");
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int codigo = rs.getInt("CD_CATEGORIA");
				String nome = rs.getString("NM_CATEGORIA");
				
				cat.add(new Categoria(codigo, nome));
			}
		}
			catch (SQLException e) {
				e.printStackTrace();
				throw new DbException("Erro ao buscar categorias");
		}
		finally {
			ConnectionManager.closeStatement(ps);
			ConnectionManager.closeResultSet(rs);
		}
		return cat;
		
	

}

	
}