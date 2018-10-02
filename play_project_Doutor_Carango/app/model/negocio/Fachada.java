package model.negocio;

import model.entidade.Cliente;
import model.negocio.ControladorClientes;

import model.entidade.Oficina;
import model.negocio.ControladorOficinas;

public class Fachada {
	private ControladorClientes clientes;
	private ControladorOficinas oficinas;

	public Fachada() {
		clientes = new ControladorClientes();
		this.clientes.cadastrar(new Cliente("A", "aaa", "1234"));
		this.clientes.cadastrar(new Cliente("B", "baa", "1234"));
		this.clientes.cadastrar(new Cliente("C", "caa", "1234"));
		oficinas = new ControladorOficinas();
		this.oficinas.cadastrar(new Oficina("Optimus", "Cybertron", 0));
		this.oficinas.cadastrar(new Oficina("Oficina", "Endereço", 0));
	}

	public void cadastrarCliente(String nome, String login, String senha) {
		this.clientes.cadastrar(new Cliente(nome, login, senha));
	}

	public Cliente buscarCliente(String login) {
		return this.clientes.buscar(login);
	}

	public void removerCliente(String login) {
		this.clientes.remover(login);
	}

	public void cadastrarOficina(String nome, String endereco) {
		this.oficinas.cadastrar(new Oficina(nome, endereco, 0));
	}

	public Oficina buscarOficina(String nome) {
		return this.oficinas.buscar(nome);
	}

	public void removerOficina(String nome) {
		this.oficinas.remover(nome);
	}
}