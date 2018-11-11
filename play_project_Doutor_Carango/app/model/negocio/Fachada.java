package model.negocio;

import java.util.HashMap;
import java.util.Map;

import model.entidade.Usuario;
import model.entidade.Cliente;
import model.entidade.Gerente;
import model.excecoes.LoginInvalidoException;
import model.excecoes.LoginJaExisteException;
import model.excecoes.LoginPequenoException;
import model.excecoes.NomeInvalidoException;
import model.excecoes.NomeVazioException;
import model.excecoes.SenhaIncorretaException;
import model.excecoes.SenhaPequenaException;
import model.negocio.NegocioClientes;
import model.negocio.NegocioGerentes;

import model.entidade.Oficina;
import model.negocio.NegocioOficinas;
import play.Logger;

public class Fachada {
	private NegocioAutenticacao autenticacao;
	private NegocioClientes clientes;
	private NegocioGerentes gerentes;
	private NegocioOficinas oficinas;

	public Fachada() {
		this.autenticacao = new NegocioAutenticacao();
		this.clientes = new NegocioClientes();
		this.gerentes = new NegocioGerentes();
		this.oficinas = new NegocioOficinas();
		try {
			this.clientes.cadastrar(
				usuarioInicial("Alexsandro Vítor Serafim de Carvalho", "avsc", "1234"));
			this.clientes.cadastrar(
				usuarioInicial("Raquel Maria Santos de Oliveira", "rmso", "1234"));
			this.gerentes.cadastrar(
				usuarioInicial("Rodolfo Jose de Souza Rocha", "rjsr", "1234"));
			this.gerentes.cadastrar(
				usuarioInicial("Orlando Verdasca Aceto", "ova", "1234"));
			this.oficinas.cadastrar(new Oficina("Optimus", "Cybertron", this.gerentes.buscar("rjsr")));
			this.oficinas.cadastrar(new Oficina("Oficina", "Endereço", this.gerentes.buscar("ova")));
		} catch (Exception e) {}
	}

	private Map<String, String> usuarioInicial(String nome, String login, String senha) {
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

	public boolean logar(Map<String, String> loginInfo) throws
			LoginPequenoException, LoginInvalidoException, SenhaIncorretaException {
		Usuario usuario;
		if (loginInfo.get("Tipo").equals("Cliente"))
			usuario = this.clientes.buscar(loginInfo.get("Login"));
		else
			usuario = this.gerentes.buscar(loginInfo.get("Login"));
		if (usuario != null) {
			this.autenticacao.logar(usuario, loginInfo.get("Senha"));
			return true;
		} return false;
	}

	public Usuario logado() {
		return this.autenticacao.getLogado();
	}

	public Cliente clienteLogado() {
		return this.autenticacao.getClienteLogado();
	}

	public Gerente gerenteLogado() {
		return this.autenticacao.getGerenteLogado();
	}

	public void deslogar() {
		this.autenticacao.deslogar();
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

	public Gerente[] listarGerentes() {
		return this.gerentes.listar();
	}

	public Gerente cadastrarGerente(Map<String, String> cliente) throws LoginPequenoException,
			LoginInvalidoException, NomeVazioException, NomeInvalidoException,
			SenhaPequenaException, LoginJaExisteException {
		return this.gerentes.cadastrar(cliente);
	}

	public Gerente buscarGerente(String login) throws LoginPequenoException, LoginInvalidoException {
		return this.gerentes.buscar(login);
	}

	public void editarGerente(String login, Map<String, String> map) throws NomeInvalidoException,
			NomeVazioException, SenhaIncorretaException, SenhaPequenaException,
			LoginPequenoException, LoginInvalidoException {
		this.gerentes.editar(login, map);
	}

	public boolean removerGerente(String login) throws LoginPequenoException, LoginInvalidoException {
		return this.gerentes.remover(login);
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