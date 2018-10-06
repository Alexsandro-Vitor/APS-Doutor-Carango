package model.colecaoEntidade;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;

import model.entidade.Cliente;

public class CadastroClientes {
	private ArrayList<Cliente> lista;

	public CadastroClientes() {
		lista = new ArrayList();
	}

	/**
	 * Cadastra um Cliente novo
	 * @param cliente O novo Cliente
	 */
	public void cadastrar(Cliente cliente) {
		this.lista.add(cliente);
	}

	/**
	 * Busca um Cliente
	 * @param login O login do Cliente buscado
	 * @return O Cliente com o login dado
	 */
	public Cliente buscar(String login) {
		ListIterator<Cliente> iterator = this.lista.listIterator();
		while (iterator.hasNext()) {
			Cliente temp = iterator.next();
			if (temp.getLogin().equals(login))
				return temp;
		}
		return null;
	}

	/**
	 * Remove um Cliente
	 * @param nome O login do Cliente buscado
	 * @return true se havia um cliente com aquele login, false caso contrário.
	 */
	public boolean remover(String login) {
		ListIterator<Cliente> iterator = this.lista.listIterator();
		while (iterator.hasNext()) {
			if (iterator.next().getLogin().equals(login)) {
				iterator.remove();
				return true;
			}
		}
		return false;
	}
}