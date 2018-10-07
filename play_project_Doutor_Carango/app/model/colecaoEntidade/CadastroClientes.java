package model.colecaoEntidade;

import java.util.Map;
import java.util.HashMap;

import model.entidade.Cliente;

public class CadastroClientes {
	private Map<String, Cliente> clientes;

	public CadastroClientes() {
		clientes = new HashMap<String, Cliente>();
	}

	/**
	 * Cadastra um Cliente novo
	 * @param cliente O novo Cliente
	 */
	public void cadastrar(Cliente cliente) {
		this.clientes.put(cliente.getLogin(), cliente);
	}

	/**
	 * Busca um Cliente
	 * @param login O login do Cliente buscado
	 * @return O Cliente com o login dado
	 */
	public Cliente buscar(String login) {
		return this.clientes.get(login);
	}

	/**
	 * Remove um Cliente
	 * @param nome O login do Cliente buscado
	 * @return true se havia um cliente com aquele login, false caso contrário.
	 */
	public boolean remover(String login) {
		boolean saida = this.clientes.containsKey(login);
		this.clientes.remove(login);
		return saida;
	}
}