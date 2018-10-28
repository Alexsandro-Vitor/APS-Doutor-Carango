package model.excecoes;

/**
 * Exceção para quando tenta-se inserir uma senha com caracteres não permitidos.
 */
public class NomeInvalidoException extends Exception {
	/**
	 * Regex contendo os caracteres válidos.
	 */
	public static final String REGEX_NOME = "[a-zA-z À-ÖØ-Ýà-öø-ý]*";
	public NomeInvalidoException() {
		super("O nome só deve conter letras (acentuadas ou não) e espaços.");
	}
}