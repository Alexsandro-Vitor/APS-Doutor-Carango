package model.negocio;

import model.entidade.Cliente;
import model.negocio.NegocioClientes;

import model.entidade.Oficina;
import model.negocio.ControladorOficinas;

public class Fachada {
	private NegocioClientes clientes;
	private ControladorOficinas oficinas;

	public Fachada() {
		clientes = new NegocioClientes();
		this.clientes.cadastrar(new Cliente("Alexsandro Vítor Serafim de Carvalho", "avsc", "1234"));
		this.clientes.cadastrar(new Cliente("Raquel Maria Santos de Oliveira", "rmso", "1234"));
		this.clientes.cadastrar(new Cliente("Rodolfo Jose de Souza Rocha", "rjsr", "1234"));
		this.clientes.cadastrar(new Cliente("Orlando Verdasca Aceto", "ova", "1234"));
		oficinas = new ControladorOficinas();
		this.oficinas.cadastrar(new Oficina("Optimus", "Cybertron", 0));
		this.oficinas.cadastrar(new Oficina("Oficina", "Endereço", 0));
	}

	public Cliente[] listarClientes() {
		return this.clientes.listar();
	}

	public void cadastrarCliente(String nome, String login, String senha) {
		this.clientes.cadastrar(new Cliente(nome, login, senha));
	}

	public Cliente buscarCliente(String login) {
		return this.clientes.buscar(login);
	}

	public boolean removerCliente(String login) {
		return this.clientes.remover(login);
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