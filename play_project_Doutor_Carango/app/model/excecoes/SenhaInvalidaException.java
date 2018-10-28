package model.excecoes;

/**
 * Exceção para quando tenta-se inserir uma senha com caracteres não permitidos.
 */
public class SenhaInvalidaException extends Exception {
	/**
	 * Regex contendo os caracteres válidos.
	 */
	public static final String REGEX_SENHA = "[a-zA-Z0-9]*";
	public SenhaInvalidaException() {
		super("A senha deve ser composta apenas de letras e números.");
	}
}