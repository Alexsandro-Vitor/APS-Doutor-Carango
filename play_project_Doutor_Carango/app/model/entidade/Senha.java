package model.entidade;

public class Senha {
	private String valor;
	public Senha(String valor) {
		this.valor = valor;
	}

	/**
	 * Checa se a senha está certa.
	 * @param senha - A senha a ser checada.
	 * @return Se as senhas são iguais.
	 */
	public boolean check(String senha) {
		return this.valor.equals(senha);
	}

	/**
	 * Retorna o tamanho da senha.
	 * @return O tamanho da senha. Caso a senha seja null, retorna 0.
	 */
	public int tamanho() {
		if (this.valor == null)
			return 0;
		return this.valor.length();
	}

	/**
	 * Valida a senha com uma expressão regular.
	 * @param regex - A expressão regular para validar a senha.
	 * @return Se a senha é válida.
	 */
	public boolean validar(String regex) {
		return this.valor.matches(regex);
	}
}