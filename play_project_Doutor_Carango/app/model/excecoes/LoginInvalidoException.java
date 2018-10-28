package model.excecoes;

/**
 * Exceção para quando tenta-se inserir um login com caracteres não permitidos.
 */
public class LoginInvalidoException extends Exception {
	/**
	 * Regex contendo os caracteres válidos.
	 */
	public static final String REGEX_LOGIN = "[a-zA-Z0-9]*";
	public LoginInvalidoException() {
		super("O login deve ser composto apenas de letras e números.");
	}
}