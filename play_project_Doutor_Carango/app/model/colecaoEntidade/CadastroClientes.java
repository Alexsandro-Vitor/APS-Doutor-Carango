package model.colecaoEntidade;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

import model.entidade.Cliente;
import model.entidade.Usuario;
import model.interfaces.IRepositorioClientes;

/**
 * Repositório no qual os Clientes são armazenados na memória. Não é persistente.
 */
public class CadastroClientes extends CadastroUsuarios implements IRepositorioClientes {

	public CadastroClientes() {
		super();
	}

	/**
	 * Gera um array com todos os Clientes do repositório.
	 * @return Todos os clientes em um array.
	 */
	public Cliente[] listar() {
		Usuario[] superSaida = super.listar();
		return Arrays.copyOf(superSaida, superSaida.length, Cliente[].class);
	}

	/**
	 * Cadastra um Cliente novo.
	 * @param cliente O novo Cliente.
	 */
	public void cadastrar(Cliente cliente) {
		super.cadastrar(cliente);
	}

	/**
	 * Busca um Cliente.
	 * @param login O login do Cliente buscado.
	 * @return O Cliente com o login dado.
	 */
	public Cliente buscar(String login) {
		return (Cliente)super.buscar(login);
	}

	/**
	 * Remove um Cliente.
	 * @param nome O login do Cliente buscado.
	 */
	public void remover(String login) {
		super.remover(login);
	}
}