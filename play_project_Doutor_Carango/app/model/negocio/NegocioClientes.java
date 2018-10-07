package model.negocio;

import model.entidade.Cliente;
import model.colecaoEntidade.CadastroClientes;

public class NegocioClientes {
	private CadastroClientes cadastro;

	public NegocioClientes() {
		cadastro = new CadastroClientes();
	}

	public Cliente[] listar() {
		return this.cadastro.listar();
	}

	public void cadastrar(Cliente cliente) {
		if (this.cadastro.buscar(cliente.getLogin()) == null)
			this.cadastro.cadastrar(cliente);
	}

	public Cliente buscar(String login) {
		return this.cadastro.buscar(login);
	}

	public boolean remover(String login) {
		return this.cadastro.remover(login);
	}
}