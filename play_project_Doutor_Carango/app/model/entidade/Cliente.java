package model.entidade;

import play.Logger;
import java.security.MessageDigest;
import java.util.Map;

public class Cliente {
	private String nome;
	private String login;
	private String senha;

	public Cliente() {}

	/**
	 * Construtor por Map de Strings.
	 * @param map - O Map com valores para as chaves "Nome", "Login" e "Senha".
	 */
	public Cliente(Map<String, String> map) {
		this.nome = map.get("Nome");
		this.login = map.get("Login");
		this.senha = hashing(map.get("Senha"));
	}

	/**
	 * Getter de nome.
	 * @return O nome do Cliente.
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Setter de nome.
	 * @param nome - O novo nome do Cliente.
	 */
	public void setNome(String nome) {
		if (nome != null) this.nome = nome;
	}

	/**
	 * Getter de login. Não existe um setter pra garantir que o login seja único.
	 * @return O login do Cliente.
	 */
	public String getLogin() {
		return this.login;
	}

	/**
	 * Getter de senha.
	 * @return A senha (com hash) do Cliente.
	 */
	public String getSenha() {
		return this.senha;
	}

	/**
	 * Setter de senha.
	 * @param senha - A nova senha, sem hashing.
	 */
	public void setSenha(String senha) {
		this.senha = hashing(senha);
	}

	/**
	 * Aplica hashing à senha para torná-la não identificável.
	 */
	public static String hashing(String valor) {
		try {
			MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
			byte[] messageDigest = algorithm.digest(valor.getBytes("UTF-8"));
			return new String(messageDigest, "UTF-8");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			return null;
		}
	}
}