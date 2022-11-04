package br.com.fiap.store.model.DAO.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.store.model.Produto;
import br.com.fiap.store.model.DAO.ProdutoDAO;
import br.com.fiap.store.model.DB.DB;
import br.com.fiap.store.model.DB.exceptions.DbException;

public class ProdutoDAOJDBC implements ProdutoDAO {

	private Connection con;
	
	public ProdutoDAOJDBC(Connection con) {
		this.con = con;
	}
	
	
	@Override
	public void cadastrar(Produto produto) {
		PreparedStatement ps = null;
		
		try {
			ps = con.prepareStatement("INSERT INTO TB_PRODUTO (CD_PRODUTO, NM_PRODUTO, VL_PRODUTO, "
					+ " DT_FABRICACAO, QT_PRODUTO) VALUES(SQ_TB_PRODUTO.NEXTVAL,?,?,?,?)");
			
			ps.setString(1, produto.getNome());
			ps.setDouble(2, produto.getValor());
			ps.setDate(3, new java.sql.Date(produto.getDataFabricacao().getTime()));
			ps.setInt(4, produto.getQuantidade());
			
			ps.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
			throw new DbException("Erro ao cadastrar");
			
		}
		finally {
			DB.closeStatement(ps);
			DB.closeConnection();
		}
		
	}

	@Override
	public void atualizar(Produto produto) {
		PreparedStatement ps = null;
		
		try {
			ps = con.prepareStatement("UPDATE TB_PRODUTO SET NM_PRODUTO = ?, VL_PRODUTO = ?, "
					+ " DT_FABRICACAO = ?, QT_PRODUTO = ? WHERE CD_PRODUTO = ?");
			
			ps.setString(1, produto.getNome());
			ps.setDouble(2, produto.getValor());
			ps.setDate(3, new java.sql.Date(produto.getDataFabricacao().getTime()));
			ps.setInt(4, produto.getQuantidade());
			ps.setInt(5, produto.getCodigo());
			
			ps.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
			throw new DbException("Erro ao atualizar");
			
		}
		finally {
			DB.closeStatement(ps);
			DB.closeConnection();
		}
		
		
		
	}

	@Override
	public void remover(int codigo) {
		PreparedStatement ps = null;
		
		try {
			ps = con.prepareStatement("DELETE * FROM TB_PRODUTO WHERE CD_PRODUTO = ?");
			
			ps.setInt(1, codigo);
			ps.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
			throw new DbException("Erro ao remover");
			
		}
		finally {
			DB.closeStatement(ps);
			DB.closeConnection();
		}
		
		
	}

	@Override
	public Produto buscar(int codigo) {
		Produto produto = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			ps = con.prepareStatement("SELECT * FROM TB_PRODUTO WHERE CD_PRODUTO = ?");
			ps.setInt(1, codigo);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				int id = rs.getInt("CD_PRODUTO");
				String nome = rs.getString("NM_PRODUTO");
				double valor = rs.getDouble("VL_PRODUTO");
				java.sql.Date date = rs.getDate("DT_FABRICACAO");
				int qnt = rs.getInt("QT_PRODUTO");
				
				produto = new Produto(id, nome, valor, date, qnt);
			}
			
		}
			catch (SQLException e) {
				e.printStackTrace();
				throw new DbException("Erro ao buscar produto");
				
			}
			finally {
				DB.closeStatement(ps);
				DB.closeResultSet(rs);
				DB.closeConnection();
			}
		return produto;
			
			
			
		}
		
	

	@Override
	public List<Produto> listar() {
		List<Produto> produtos = new ArrayList<Produto>();
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		try {
			
			ps = con.prepareStatement("SELECT * FROM TB_PRODUTO");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int id = rs.getInt("CD_PRODUTO");
				String nome = rs.getString("NM_PRODUTO");
				double valor = rs.getDouble("VL_PRODUTO");
				java.sql.Date date = rs.getDate("DT_FABRICACAO");
				int qnt = rs.getInt("QT_PRODUTO");
				
				produtos.add(new Produto(id, nome, valor, date, qnt));
				
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
			throw new DbException("Erro ao buscar lista de produtos");
			
		}
		finally {
			DB.closeStatement(ps);
			DB.closeResultSet(rs);
			DB.closeConnection();
		}
		
		return produtos;
		
	
	}
	
	

}
