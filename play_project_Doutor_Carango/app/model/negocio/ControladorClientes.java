package model.negocio;

import java.util.ArrayList;

import javax.inject.*;

import model.entidade.Cliente;
import model.colecaoEntidade.CadastroClientes;

public class ControladorClientes {
	private CadastroClientes cadastro;

	public ControladorClientes() {
		cadastro = new CadastroClientes();
	}

	public void cadastrar(Cliente cliente) {
		this.cadastro.cadastrar(cliente);
	}

	public Cliente buscar(String login) {
		return this.cadastro.buscar(login);
	}

	public void remover(String login) {
		this.cadastro.remover(login);
	}
}