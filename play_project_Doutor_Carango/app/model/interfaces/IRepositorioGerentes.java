package model.interfaces;

import model.entidade.Gerente;

/**
 * Interface que define as funções necessárias para um repositório de Gerentes.
 */
public interface IRepositorioGerentes {
	/**
	 * Gera um array com todos os Gerentes da base de dados.
	 * @return Todos os gerentes em um array.
	 */
	Gerente[] listar();
	/**
	 * Cadastra um Gerente novo.
	 * @param gerente O novo Gerente.
	 */
	void cadastrar(Gerente gerente);
	/**
	 * Busca um Gerente.
	 * @param login O login do Gerente buscado.
	 * @return O Gerente com o login dado.
	 */
	Gerente buscar(String login);
	/**
	 * Remove um Gerente.
	 * @param nome O login do Gerente buscado.
	 */
	void remover(String login);
}