package model.entidade;

import java.util.Map;

public class Oficina {
	private String nome;
	private String endereco;
	private int id;

	public Oficina() {}

	public Oficina(String nome, String endereco) {
		this.nome = nome;
		this.endereco = endereco;
	}

	public Oficina(Map<String, String> map) {
		this.nome = map.get("Nome");
		this.endereco = map.get("Endereco");
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

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
}