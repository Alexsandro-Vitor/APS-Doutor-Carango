package model.interfaces;

import model.entidade.Cliente;

/**
 * Interface que define as funções necessárias para um repositório de Clientes.
 */
public interface IRepositorioClientes {
	/**
	 * Gera um array com todos os Clientes da base de dados.
	 * @return Todos os clientes em um array.
	 */
	Cliente[] listar();
	/**
	 * Cadastra um Cliente novo.
	 * @param cliente O novo Cliente.
	 */
	void cadastrar(Cliente cliente);
	/**
	 * Busca um Cliente.
	 * @param login O login do Cliente buscado.
	 * @return O Cliente com o login dado.
	 */
	Cliente buscar(String login);
	/**
	 * Remove um Cliente.
	 * @param nome O login do Cliente buscado.
	 */
	void remover(String login);
}