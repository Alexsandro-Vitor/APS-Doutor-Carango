package model.negocio;

import java.util.HashMap;
import java.util.Map;

import model.entidade.Cliente;
import model.excecoes.LoginInvalidoException;
import model.excecoes.LoginJaExisteException;
import model.excecoes.LoginPequenoException;
import model.excecoes.NomeInvalidoException;
import model.excecoes.NomeVazioException;
import model.excecoes.SenhaIncorretaException;
import model.excecoes.SenhaPequenaException;
import model.negocio.NegocioClientes;

import model.entidade.Oficina;
import model.negocio.NegocioOficinas;
import play.Logger;

public class Fachada {
	private NegocioAutenticacao autenticacao;
	private NegocioClientes clientes;
	private NegocioOficinas oficinas;

	public Fachada() {
		autenticacao = new NegocioAutenticacao();
		clientes = new NegocioClientes();
		try {
			this.clientes.cadastrar(
				clienteInicial("Alexsandro Vítor Serafim de Carvalho", "avsc", "1234"));
			this.clientes.cadastrar(
				clienteInicial("Raquel Maria Santos de Oliveira", "rmso", "1234"));
			this.clientes.cadastrar(
				clienteInicial("Rodolfo Jose de Souza Rocha", "rjsr", "1234"));
			this.clientes.cadastrar(
				clienteInicial("Orlando Verdasca Aceto", "ova", "1234"));
			oficinas = new NegocioOficinas();
			this.oficinas.cadastrar(new Oficina("Optimus", "Cybertron"));
			this.oficinas.cadastrar(new Oficina("Oficina", "Endereço"));
		} catch (Exception e) {}
	}

	private Map<String, String> clienteInicial(String nome, String login, String senha) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("Nome", nome);
		map.put("Login", login);
		map.put("Senha", senha);
		return map;
	}

	private static Fachada instance;
	public static Fachada getInstance() {
		if (Fachada.instance == null)
			Fachada.instance = new Fachada();
		return Fachada.instance;
	}

	public boolean logar(Map<String, String> loginInfo) throws LoginPequenoException,
			LoginInvalidoException, SenhaIncorretaException {
		Cliente cliente = this.clientes.buscar(loginInfo.get("Login"));
		if (cliente != null) {
			this.autenticacao.logar(cliente, loginInfo.get("Senha"));
			return true;
		} return false;
	}

	public Cliente logado() {
		return this.autenticacao.getLogado();
	}

	public Cliente[] listarClientes() {
		return this.clientes.listar();
	}

	public Cliente cadastrarCliente(Map<String, String> cliente) throws LoginPequenoException,
			LoginInvalidoException, NomeVazioException, NomeInvalidoException,
			SenhaPequenaException, LoginJaExisteException {
		return this.clientes.cadastrar(cliente);
	}

	public Cliente buscarCliente(String login) throws LoginPequenoException, LoginInvalidoException {
		return this.clientes.buscar(login);
	}

	public void editarCliente(String login, Map<String, String> map) throws NomeInvalidoException,
			NomeVazioException, SenhaIncorretaException, SenhaPequenaException,
			LoginPequenoException, LoginInvalidoException {
		this.clientes.editar(login, map);
	}

	public boolean removerCliente(String login) throws LoginPequenoException, LoginInvalidoException {
		return this.clientes.remover(login);
	}

	public Oficina[] listarOficinas() {
		return this.oficinas.listar();
	}

	public void cadastrarOficina(Oficina oficina) {
		this.oficinas.cadastrar(oficina);
	}

	public Oficina buscarOficina(int id) {
		return this.oficinas.buscar(id);
	}

	public boolean removerOficina(int id) {
		return this.oficinas.remover(id);
	}
}