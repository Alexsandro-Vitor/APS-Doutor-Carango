package model.negocio;

import model.entidade.Cliente;
import model.negocio.NegocioClientes;

import model.entidade.Oficina;
import model.negocio.NegocioOficinas;

public class Fachada {
	private NegocioClientes clientes;
	private NegocioOficinas oficinas;

	public Fachada() {
		clientes = new NegocioClientes();
		this.clientes.cadastrar(new Cliente("Alexsandro Vítor Serafim de Carvalho", "avsc", "1234"));
		this.clientes.cadastrar(new Cliente("Raquel Maria Santos de Oliveira", "rmso", "1234"));
		this.clientes.cadastrar(new Cliente("Rodolfo Jose de Souza Rocha", "rjsr", "1234"));
		this.clientes.cadastrar(new Cliente("Orlando Verdasca Aceto", "ova", "1234"));
		oficinas = new NegocioOficinas();
		this.oficinas.cadastrar(new Oficina("Optimus", "Cybertron", 0));
		this.oficinas.cadastrar(new Oficina("Oficina", "Endereço", 0));
	}

	private static Fachada instance;
	public static Fachada getInstance() {
		if (Fachada.instance == null)
			Fachada.instance = new Fachada();
		return Fachada.instance;
	}

	public Cliente[] listarClientes() {
		return this.clientes.listar();
	}

	public boolean cadastrarCliente(Cliente cliente) {
		return this.clientes.cadastrar(cliente);
	}

	public Cliente buscarCliente(String login) {
		return this.clientes.buscar(login);
	}

	public boolean removerCliente(String login) {
		return this.clientes.remover(login);
	}

	public Oficina[] listarOficinas() {
		return this.oficinas.listar();
	}

	public void cadastrarOficina(Oficina oficina) {
		this.oficinas.cadastrar(oficina);
	}

	public Oficina buscarOficina(String nome) {
		return this.oficinas.buscar(nome);
	}

	public boolean removerOficina(String nome) {
		return this.oficinas.remover(nome);
	}
}