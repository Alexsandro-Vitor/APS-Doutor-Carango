package model.entidade;

import java.util.Map;

public class Cliente {
	private String nome;
	private String login;
	private Senha senha;

	public Cliente() {}

	/**
	 * Construtor por atributos, usado para a inicialização inicial.
	 * @param nome - O nome do Cliente.
	 * @param login - O login do Cliente.
	 * @param senha - A senha do Cliente.
	 */
	public Cliente(String nome, String login, String senha) {
		this.nome = nome;
		this.login = login;
		this.senha = new Senha(senha);
	}

	/**
	 * Construtor por Map de Strings.
	 * @param map - O Map com valores para as chaves "Nome", "Login" e "Senha".
	 */
	public Cliente(Map<String, String> map) {
		this.nome = map.get("Nome");
		this.login = map.get("Login");
		this.senha = new Senha(map.get("Senha"));
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
	 * Checa se a senha está certa.
	 * @param senha - A senha a ser checada.
	 * @return Se as senhas são iguais.
	 */
	public boolean checkSenha(String senha) {
		return this.senha.check(senha);
	}

	/**
	 * Retorna o tamanho da senha.
	 * @return O tamanho da senha. Caso a senha seja null, retorna 0.
	 */
	public int tamSenha() {
		return this.senha.tamanho();
	}

	/**
	 * Valida a senha com uma expressão regular.
	 * @param regex - A expressão regular para validar a senha.
	 * @return Se a senha é válida.
	 */
	public boolean validarSenha(String regex) {
		return this.senha.validar(regex);
	}

	/**
	 * Setter de senha.
	 * @param senha - A nova senha.
	 */
	public void setSenha(String senha) {
		this.senha = new Senha(senha);
	}
}