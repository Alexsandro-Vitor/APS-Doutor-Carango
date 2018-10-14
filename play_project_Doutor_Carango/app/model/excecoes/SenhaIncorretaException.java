package model.excecoes;

/**
 * Exceção para quando a senha de um Cliente está errada.
 */
public class SenhaIncorretaException extends Exception {
	public SenhaIncorretaException() {
		super("A senha está incorreta");
	}
}