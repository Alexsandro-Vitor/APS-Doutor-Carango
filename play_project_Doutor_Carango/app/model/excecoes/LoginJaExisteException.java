package model.excecoes;

/**
 * Exceção para quando tenta-se cadastrar um Cliente com o mesmo login de outro que já existe.
 */
public class LoginJaExisteException extends Exception {
	public LoginJaExisteException() {
		super("O login inserido já está sendo usado.");
	}
}