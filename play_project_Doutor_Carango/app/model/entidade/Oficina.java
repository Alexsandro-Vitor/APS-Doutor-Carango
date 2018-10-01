package model.entidade;

public class Oficina {
	private String nome;
	private String endereco;

	public Oficina(String nome, String endereco) {
		this.nome = nome;
		this.endereco = endereco;
	}

	public String getNome() {
		return this.nome;
	}

	public String getEndereco() {
		return this.endereco;
	}
}