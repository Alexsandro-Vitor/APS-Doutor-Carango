package model.excecoes;

/**
 * Exceção para quando tenta-se inserir uma senha com caracteres não permitidos.
 */
public class NomeInvalidoException extends Exception {
	public NomeInvalidoException() {
		super("O nome não pode conter caracteres como /\\*()#;");
	}
}