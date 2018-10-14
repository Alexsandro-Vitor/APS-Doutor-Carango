package model.excecoes;

/**
 * Exceção para quando tenta-se mudar a senha para uma menor que o especificado em TAM_MINIMO.
 */
public class SenhaPequenaException extends Exception {
	/**
	 * Tamanho mínimo de uma senha válida.
	 */
	public static final int TAM_MINIMO = 4;
	public SenhaPequenaException() {
		super("Uma senha precisa ter, no mínimo, "+ SenhaPequenaException.TAM_MINIMO +" caracteres.");
	}
}