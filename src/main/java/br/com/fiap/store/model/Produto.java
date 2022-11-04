package br.com.fiap.store.model;



import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Produto implements Serializable {
	

	private static final long serialVersionUID = 1L;
	private int codigo;
	private String nome;
	private double valor;
	private Date dataFabricacao;
	private int quantidade;
	
	public Produto() {
		
	}

	public Produto(int codigo, String nome, double valor, Date dataFabricacao, int quantidade) {
		this.codigo = codigo;
		this.nome = nome;
		this.valor = valor;
		this.dataFabricacao = dataFabricacao;
		this.quantidade = quantidade;
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

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Date getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
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
		Produto other = (Produto) obj;
		return codigo == other.codigo;
	}

	@Override
	public String toString() {
		return "Produto [codigo=" + codigo + ", nome=" + nome + ", valor=" + valor + ", dataFabricacao="
				+ dataFabricacao + ", quantidade=" + quantidade + "]";
	}
	
	
	
	

}