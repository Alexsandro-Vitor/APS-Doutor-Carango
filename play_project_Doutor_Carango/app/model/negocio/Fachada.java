package model.negocio;

import java.util.Map;

import model.entidade.Cliente;
import model.excecoes.LoginInvalidoException;
import model.excecoes.LoginJaExisteException;
import model.excecoes.LoginPequenoException;
import model.excecoes.NomeInvalidoException;
import model.excecoes.NomeVazioException;
import model.excecoes.SenhaIncorretaException;
import model.excecoes.SenhaInvalidaException;
import model.excecoes.SenhaPequenaException;
import model.negocio.NegocioClientes;

import model.entidade.Oficina;
import model.negocio.NegocioOficinas;

public class Fachada {
	private NegocioClientes clientes;
	private NegocioOficinas oficinas;

	public Fachada() {
		clientes = new NegocioClientes();
		try {
			this.clientes.cadastrar(new Cliente("Alexsandro Vítor Serafim de Carvalho", "avsc", "1234"));
			this.clientes.cadastrar(new Cliente("Raquel Maria Santos de Oliveira", "rmso", "1234"));
			this.clientes.cadastrar(new Cliente("Rodolfo Jose de Souza Rocha", "rjsr", "1234"));
			this.clientes.cadastrar(new Cliente("Orlando Verdasca Aceto", "ova", "1234"));
			oficinas = new NegocioOficinas();
			this.oficinas.cadastrar(new Oficina("Optimus", "Cybertron", 0));
			this.oficinas.cadastrar(new Oficina("Oficina", "Endereço", 0));
		} catch (Exception e) {}
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

	public void cadastrarCliente(Cliente cliente) throws LoginPequenoException, LoginInvalidoException,
			NomeVazioException, NomeInvalidoException, SenhaPequenaException, SenhaInvalidaException,
			LoginJaExisteException {
		this.clientes.cadastrar(cliente);
	}

	public Cliente buscarCliente(String login) throws LoginPequenoException, LoginInvalidoException {
		return this.clientes.buscar(login);
	}

	public void editarCliente(String login, Map<String, String> map) throws NomeInvalidoException,
			NomeVazioException, SenhaIncorretaException, SenhaPequenaException, SenhaInvalidaException,
			LoginPequenoException, LoginInvalidoException {
		this.clientes.editar(login, map);
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