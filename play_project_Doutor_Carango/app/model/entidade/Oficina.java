package model.entidade;

public class Oficina {
	private String nome;
	private String endereco;
	private double rankingQualidade;

	public Oficina(String nome, String endereco, double qualidade) {
		this.nome = nome;
		this.endereco = endereco;
		this.rankingQualidade = qualidade;
	}

	public String getNome() {
		return this.nome;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public double getRankingQualidade() {
		return this.rankingQualidade;
	}
}