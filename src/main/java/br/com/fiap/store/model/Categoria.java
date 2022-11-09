package br.com.fiap.store.model;

import java.io.Serializable;
import java.util.Objects;

public class Categoria implements Serializable {

	private static final long serialVersionUID = 1L;

	private int codigo;
	private String nome;
	
	
	public Categoria() {
		
	}


	public Categoria(int codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return codigo == other.codigo;
	}


	@Override
	public String toString() {
		return "Categoria [codigo=" + codigo + ", nome=" + nome + "]";
	}
	
	
	
}
