package br.com.fiap.store.model.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.store.model.Usuario;
import br.com.fiap.store.model.DAO.UsuarioDAO;
import br.com.fiap.store.model.DB.ConnectionManager;

public class UsuarioDAOJDBC implements UsuarioDAO {
	
	private Connection con;

	@Override
	public boolean validarUsuario(Usuario usuario) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = ConnectionManager.getInstance().getConnection();
			ps = con.prepareStatement("SELECT * FROM TB_USUARIO WHERE DS_EMAIL = ? AND DS_SENHA = ?");
			ps.setString(1, usuario.getEmail());
			ps.setString(2, usuario.getSenha());
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				return true;
			}
			
		}
		catch (SQLException e) {
			e.getMessage();
		}
		finally {
			ConnectionManager.closeStatement(ps);
			ConnectionManager.closeResultSet(rs);
		}
		return false;
		
		
		
	}
	
	

}
