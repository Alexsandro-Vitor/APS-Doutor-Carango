package model.colecaoEntidade;

import java.util.Map;
import java.util.HashMap;

import model.entidade.Cliente;

public class CadastroClientes {
	private Map<String, Cliente> clientes;

	public CadastroClientes() {
		this.clientes = new HashMap<String, Cliente>();
	}

	/**
	 * Gera um array com todos os Clientes da base de dados
	 * @return Todos os clientes em um array
	 */
	public Cliente[] listar() {
		Cliente[] saida = new Cliente[this.clientes.size()];
		int i = 0;
		for (String key : this.clientes.keySet()) {
			saida[i++] = this.clientes.get(key);
		}
		return saida;
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