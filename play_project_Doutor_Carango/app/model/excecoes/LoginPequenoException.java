package model.excecoes;

/**
 * Exceção para quando tenta-se mudar o login para um menor que o especificado em TAM_MINIMO.
 */
public class LoginPequenoException extends Exception {
	/**
	 * Tamanho mínimo de um login válido.
	 */
	public static final int TAM_MINIMO = 3;
	public LoginPequenoException() {
		super("O login precisa ter, no mínimo, "+ LoginPequenoException.TAM_MINIMO +" caracteres.");
	}
}