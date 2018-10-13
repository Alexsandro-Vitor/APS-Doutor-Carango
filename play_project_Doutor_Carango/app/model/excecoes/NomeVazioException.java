package model.excecoes;

/**
 * Exceção para quando tenta-se cadastrar um Cliente sem nome.
 */
public class NomeVazioException extends Exception {
	public NomeVazioException() {
		super("É preciso preencher um nome");
	}
}