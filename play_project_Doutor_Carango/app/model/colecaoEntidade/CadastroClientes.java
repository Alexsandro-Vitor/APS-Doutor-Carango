package model.colecaoEntidade;

import java.util.ArrayList;
import java.util.ListIterator;

import model.entidade.Cliente;

public class CadastroClientes {
	private ArrayList<Cliente> lista;

	public CadastroClientes() {
		lista = new ArrayList();
	}

	/**
	 * Cadastra um cliente novo
	 * @param cliente O novo Cliente
	 */
	public void cadastrar(Cliente cliente) {
		this.lista.add(cliente);
	}

	/**
	 * Busca um Cliente
	 * @param login O login do cliente buscado
	 * @return O cliente com o login dado
	 */
	public Cliente buscar(String login) {
		ListIterator<Cliente> iterator = this.lista.listIterator();
		while (iterator.hasNext()) {
			if (iterator.next().getLogin().equals(login))
				return iterator.next();
		}
		return null;
	}
}