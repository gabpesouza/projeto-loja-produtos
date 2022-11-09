package br.com.fiap.store.model.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.store.model.Categoria;
import br.com.fiap.store.model.Produto;
import br.com.fiap.store.model.DAO.ProdutoDAO;
import br.com.fiap.store.model.DB.ConnectionManager;
import br.com.fiap.store.model.DB.exceptions.DbException;

public class ProdutoDAOJDBC implements ProdutoDAO {

	private Connection con;
	
	
	
	@Override
	public void cadastrar(Produto produto) {
		PreparedStatement ps = null;
		
		try {
			con = ConnectionManager.getInstance().getConnection();
			ps = con.prepareStatement("INSERT INTO TB_PRODUTO (CD_PRODUTO, NM_PRODUTO, VL_PRODUTO, "
					+ " DT_FABRICACAO, QT_PRODUTO, CD_CATEGORIA) VALUES(SQ_TB_PRODUTO.NEXTVAL,?,?,?,?,?)");
			
			ps.setString(1, produto.getNome());
			ps.setDouble(2, produto.getValor());
			ps.setDate(3, new java.sql.Date(produto.getDataFabricacao().getTime()));
			ps.setInt(4, produto.getQuantidade());
			ps.setInt(5, produto.getCategoria().getCodigo());
			
			ps.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
			throw new DbException("Erro ao cadastrar");
			
		}
		finally {
			ConnectionManager.closeStatement(ps);
		
		}
		
	}

	@Override
	public void atualizar(Produto produto) {
		PreparedStatement ps = null;
		
		try {
			con = ConnectionManager.getInstance().getConnection();
			ps = con.prepareStatement("UPDATE TB_PRODUTO SET NM_PRODUTO = ?, VL_PRODUTO = ?, "
					+ " DT_FABRICACAO = ?, QT_PRODUTO = ?, CD_CATEGORIA = ?  WHERE CD_PRODUTO = ?");
			
			ps.setString(1, produto.getNome());
			ps.setDouble(2, produto.getValor());
			ps.setDate(3, new java.sql.Date(produto.getDataFabricacao().getTime()));
			ps.setInt(4, produto.getQuantidade());
			ps.setInt(5, produto.getCategoria().getCodigo());
			ps.setInt(6, produto.getCodigo());
			
			ps.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
			throw new DbException("Erro ao atualizar");
			
		}
		finally {
			ConnectionManager.closeStatement(ps);
		
		}
		
		
		
	}

	@Override
	public void remover(int codigo) {
		PreparedStatement ps = null;
		
		try {
			con = ConnectionManager.getInstance().getConnection();
			ps = con.prepareStatement("DELETE FROM TB_PRODUTO WHERE CD_PRODUTO = ?");
			
			ps.setInt(1, codigo);
			ps.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
			throw new DbException("Erro ao remover");
			
		}
		finally {
			ConnectionManager.closeStatement(ps);
	
		}
		
		
	}

	@Override
	public Produto buscar(int codigo) {
		Produto produto = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = ConnectionManager.getInstance().getConnection();
			ps = con.prepareStatement("SELECT * FROM TB_PRODUTO INNER JOIN TB_CATEGORIA ON TB_PRODUTO.CD_CATEGORIA "
					+ " = TB_CATEGORIA.CD_CATEGORIA WHERE TB_PRODUTO.CD_PRODUTO = ?");
			ps.setInt(1, codigo);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				int id = rs.getInt("CD_PRODUTO");
				String nome = rs.getString("NM_PRODUTO");
				double valor = rs.getDouble("VL_PRODUTO");
				java.sql.Date date = rs.getDate("DT_FABRICACAO");
				int qnt = rs.getInt("QT_PRODUTO");
				int codCategoria = rs.getInt("CD_CATEGORIA");
				String nomeCategoria = rs.getString("NM_CATEGORIA");
				
				produto = new Produto(id, nome, valor, date, qnt);
				Categoria cat = new Categoria(codCategoria, nomeCategoria);
				produto.setCategoria(cat);
			}
			
		}
			catch (SQLException e) {
				e.printStackTrace();
				throw new DbException("Erro ao buscar produto");
				
			}
			finally {
				ConnectionManager.closeStatement(ps);
				ConnectionManager.closeResultSet(rs);
			
			}
		return produto;
			
			
			
		}
		
	

	@Override
	public List<Produto> listar() {
		List<Produto> produtos = new ArrayList<Produto>();
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		try {
			con = ConnectionManager.getInstance().getConnection();
			ps = con.prepareStatement("SELECT * FROM TB_PRODUTO INNER JOIN TB_CATEGORIA ON TB_PRODUTO.CD_CATEGORIA "
					+ " = TB_CATEGORIA.CD_CATEGORIA");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int id = rs.getInt("CD_PRODUTO");
				String nome = rs.getString("NM_PRODUTO");
				double valor = rs.getDouble("VL_PRODUTO");
				java.sql.Date date = rs.getDate("DT_FABRICACAO");
				int qnt = rs.getInt("QT_PRODUTO");
				int codCategoria = rs.getInt("CD_CATEGORIA");
				String nomeCategoria = rs.getString("NM_CATEGORIA");
				
				Produto prod = new Produto(id,nome,valor,date,qnt);
				Categoria cat = new Categoria(codCategoria, nomeCategoria);
				prod.setCategoria(cat);
				
				
				produtos.add(prod);
				
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
			throw new DbException("Erro ao buscar lista de produtos");
			
		}
		finally {
			ConnectionManager.closeStatement(ps);
			ConnectionManager.closeResultSet(rs);
		
		}
		
		return produtos;
		
	
	}
	
	

}
