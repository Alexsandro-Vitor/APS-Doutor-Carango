package model.entidade;

import com.typesafe.config.ConfigException.Null;

public class Cliente {
	private String nome;
	private String login;
	private String senha;

	public Cliente() {}

	public Cliente(String nome, String login, String senha) {
		this.nome = nome;
		this.login = login;
		this.senha = senha;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return this.login;
	}

	/**
	 * Checa se a senha está certa. É feito desse jeito porque acho que um getter seria uma brecha de segurança
	 * @param senha - A senha a ser checada
	 * @return Se as senhas são iguais
	 */
	public boolean checkSenha(String senha) {
		return this.senha.equals(senha);
	}

	public int tamSenha() {
		if (this.senha == null)
			return 0;
		return this.senha.length();
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}