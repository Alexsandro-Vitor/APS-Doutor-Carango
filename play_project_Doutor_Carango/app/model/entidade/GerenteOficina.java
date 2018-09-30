package model.entidade;

public class GerenteOficina {
	private String nome;
	private String login;
	private String senha;

	public GerenteOficina(nome, login, senha) {
		this.nome = nome;
		this.login = login;
		this.senha = senha;
	}

	public String getNome() {
		return this.nome;
	}

	public String getLogin() {
		return this.login;
	}

	public String getSenha() {
		return this.senha;
	}
}