package br.com.fiap.store.model.DAO;

import java.util.List;

import br.com.fiap.store.model.Produto;

public interface ProdutoDAO {
	
	
	void cadastrar (Produto produto);
	void atualizar (Produto produto);
	void remover (int codigo);
	Produto buscar(int codigo);
	List<Produto> listar();

}
