package model.colecaoEntidade;

import java.util.Map;
import java.util.HashMap;

import model.entidade.Cliente;
import model.interfaces.IRepositorioClientes;

/**
 * Repositório no qual os Clientes são armazenados na memória. Não é persistente.
 */
public class CadastroClientes implements IRepositorioClientes {
	private Map<String, Cliente> clientes;

	public CadastroClientes() {
		this.clientes = new HashMap<String, Cliente>();
	}

	/**
	 * Gera um array com todos os Clientes do repositório.
	 * @return Todos os clientes em um array.
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
	 * Cadastra um Cliente novo.
	 * @param cliente O novo Cliente.
	 */
	public void cadastrar(Cliente cliente) {
		this.clientes.put(cliente.getLogin(), cliente);
	}

	/**
	 * Busca um Cliente.
	 * @param login O login do Cliente buscado.
	 * @return O Cliente com o login dado.
	 */
	public Cliente buscar(String login) {
		return this.clientes.get(login);
	}

	/**
	 * Remove um Cliente.
	 * @param nome O login do Cliente buscado.
	 */
	public void remover(String login) {
		this.clientes.remove(login);
	}
}