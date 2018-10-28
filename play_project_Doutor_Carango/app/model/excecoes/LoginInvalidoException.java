package model.excecoes;

/**
 * Exceção para quando tenta-se inserir um login com caracteres não permitidos.
 */
public class LoginInvalidoException extends Exception {
	public LoginInvalidoException() {
		super("O login deve ser composto apenas de letras e números.");
	}
}