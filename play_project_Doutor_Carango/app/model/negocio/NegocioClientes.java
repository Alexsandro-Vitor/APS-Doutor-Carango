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

	public boolean cadastrar(Cliente cliente) {
		if (cliente.getLogin() != null && cliente.getNome() != null
				&& this.cadastro.buscar(cliente.getLogin()) == null
				&& cliente.getLogin().length() >= 3 && cliente.tamSenha() >= 4) {
			this.cadastro.cadastrar(cliente);
			return true;
		} return false;
	}

	public Cliente buscar(String login) {
		return this.cadastro.buscar(login);
	}

	public boolean remover(String login) {
		return this.cadastro.remover(login);
	}
}