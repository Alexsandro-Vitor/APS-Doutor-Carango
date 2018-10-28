package model.excecoes;

/**
 * Exceção para quando tenta-se inserir uma senha com caracteres não permitidos.
 */
public class SenhaInvalidaException extends Exception {
	public SenhaInvalidaException() {
		super("A senha deve ser composta apenas de letras e números.");
	}
}