package model.entidade;

public class Oficina {
	private String nome;
	private String endereco;
	private int id;

	public Oficina(String nome, String endereco, int id) {
		this.nome = nome;
		this.endereco = endereco;
		this.id = id;
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

	public double getId() {
		return this.id;
	}
}