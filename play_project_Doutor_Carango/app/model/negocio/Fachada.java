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

	/**
	 * Gera um Map para correspondente a um Usuario para povoamento inicial da Fachada.
	 * @param nome O nome do Usuario.
	 * @param login O login do Usuario.
	 * @param senha A senha do Usuario.
	 * @return O Map para o povoamento.
	 */
	private Map<String, String> usuarioInicial(String nome, String login, String senha) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("Nome", nome);
		map.put("Login", login);
		map.put("Senha", senha);
		return map;
	}

	private static Fachada instance;
	/**
	 * Obtem a instancia da Fachada.
	 * @return A única instancia da Fachada.
	 */
	public static Fachada getInstance() {
		if (Fachada.instance == null)
			Fachada.instance = new Fachada();
		return Fachada.instance;
	}

	/**
	 * Autentica um Usuario.
	 * @param loginInfo O Map com as entradas do Usuario.
	 * @throws LoginPequenoException Se o login tiver menos de 3 caracteres.
	 * @throws LoginInvalidoException Se o login conter caracteres inválidos.
	 * @throws SenhaIncorretaException Se a senha atual estiver incorreta.
	 * @return true se tiver logado, false caso contrário.
	 */
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

	/**
	 * Obtem o Usuario logado.
	 * @return O Usuario logado.
	 */
	public Usuario logado() {
		return this.autenticacao.getLogado();
	}

	/**
	 * Obtem o Usuario logado, se ele for um Cliente.
	 * @return O Cliente logado, se houver um.
	 */
	public Cliente clienteLogado() {
		return this.autenticacao.getClienteLogado();
	}

	/**
	 * Obtem o Usuario logado, se ele for um Gerente.
	 * @return O Gerente logado, se houver um.
	 */
	public Gerente gerenteLogado() {
		return this.autenticacao.getGerenteLogado();
	}

	/**
	 * Desloga o Usuario atual.
	 */
	public void deslogar() {
		this.autenticacao.deslogar();
	}

	/**
	 * Gera um array com todos os Clientes do repositório.
	 * @return Todos os clientes em um array.
	 */
	public Cliente[] listarClientes() {
		return this.clientes.listar();
	}

	/**
	 * Cadastra um Cliente novo.
	 * @param cliente Os dados do novo Cliente.
	 * @return O novo Cliente.
	 * @throws LoginPequenoException Se o login tiver menos de 3 caracteres.
	 * @throws LoginInvalidoException Se o login conter caracteres inválidos.
	 * @throws NomeVazioException Se o nome não for preenchido.
	 * @throws NomeInvalidoException Se o nome conter caracteres inválidos.
	 * @throws SenhaPequenaException Se a senha tiver menos de 4 caracteres.
	 * @throws LoginJaExisteException Se já existe um Cliente com esse nome.
	 */
	public Cliente cadastrarCliente(Map<String, String> cliente) throws LoginPequenoException,
			LoginInvalidoException, NomeVazioException, NomeInvalidoException,
			SenhaPequenaException, LoginJaExisteException {
		return this.clientes.cadastrar(cliente);
	}

	/**
	 * Busca um Cliente no repositório.
	 * @param login O login do Cliente buscado.
	 * @return O Cliente que possui aquele login, se ele não existir, retorna null.
	 * @throws LoginPequenoException Se o login tiver menos de 3 caracteres.
	 * @throws LoginInvalidoException Se o login conter caracteres inválidos.
	 */
	public Cliente buscarCliente(String login) throws LoginPequenoException, LoginInvalidoException {
		return this.clientes.buscar(login);
	}

	/**
	 * Edita as informações de um Cliente.
	 * @param login O login do Cliente a ser editado.
	 * @param map Um Map de valores para a edição do Cliente.
	 * @throws NomeVazioException Se o nome não for preenchido.
	 * @throws NomeInvalidoException Se o nome conter caracteres inválidos.
	 * @throws SenhaIncorretaException Se a senha atual estiver incorreta.
	 * @throws SenhaPequenaException Se a nova senha tiver menos de 4 caracteres.
	 * @throws LoginPequenoException Se o login tiver menos de 3 caracteres.
	 * @throws LoginInvalidoException Se o login conter caracteres inválidos.
	 */
	public void editarCliente(String login, Map<String, String> map) throws NomeInvalidoException,
			NomeVazioException, SenhaIncorretaException, SenhaPequenaException,
			LoginPequenoException, LoginInvalidoException {
		this.clientes.editar(login, map);
	}

	/**
	 * Remove um Cliente do repositório.
	 * @param login O login do Cliente a ser removido.
	 * @return Se havia um Cliente com o login dado.
	 * @throws LoginPequenoException Se o login tiver menos de 3 caracteres.
	 * @throws LoginInvalidoException Se o login conter caracteres inválidos.
	 */
	public boolean removerCliente(String login) throws LoginPequenoException, LoginInvalidoException {
		return this.clientes.remover(login);
	}

	/**
	 * Gera um array com todos os Gerentes do repositório.
	 * @return Todos os gerentes em um array.
	 */
	public Gerente[] listarGerentes() {
		return this.gerentes.listar();
	}

	/**
	 * Cadastra um Gerente novo.
	 * @param gerente Os dados do novo Gerente.
	 * @throws LoginPequenoException Se o login tiver menos de 3 caracteres.
	 * @throws LoginInvalidoException Se o login conter caracteres inválidos.
	 * @throws NomeVazioException Se o nome não for preenchido.
	 * @throws NomeInvalidoException Se o nome conter caracteres inválidos.
	 * @throws SenhaPequenaException Se a senha tiver menos de 4 caracteres.
	 * @throws LoginJaExisteException Se já existe um Gerente com esse nome.
	 * @return O novo Gerente.
	 */
	public Gerente cadastrarGerente(Map<String, String> cliente) throws LoginPequenoException,
			LoginInvalidoException, NomeVazioException, NomeInvalidoException,
			SenhaPequenaException, LoginJaExisteException {
		return this.gerentes.cadastrar(cliente);
	}

	/**
	 * Busca um Gerente no repositório.
	 * @param login O login do Gerente buscado.
	 * @return O Gerente que possui aquele login, se ele não existir, retorna null.
	 * @throws LoginPequenoException Se o login tiver menos de 3 caracteres.
	 * @throws LoginInvalidoException Se o login conter caracteres inválidos.
	 */
	public Gerente buscarGerente(String login) throws LoginPequenoException, LoginInvalidoException {
		return this.gerentes.buscar(login);
	}

	/**
	 * Edita as informações de um Gerente.
	 * @param login O login do Gerente a ser editado.
	 * @param map Um Map de valores para a edição do Gerente.
	 * @throws NomeVazioException Se o nome não for preenchido.
	 * @throws NomeInvalidoException Se o nome conter caracteres inválidos.
	 * @throws SenhaIncorretaException Se a senha atual estiver incorreta.
	 * @throws SenhaPequenaException Se a nova senha tiver menos de 4 caracteres.
	 * @throws LoginPequenoException Se o login tiver menos de 3 caracteres.
	 * @throws LoginInvalidoException Se o login conter caracteres inválidos.
	 */
	public void editarGerente(String login, Map<String, String> map) throws NomeInvalidoException,
			NomeVazioException, SenhaIncorretaException, SenhaPequenaException,
			LoginPequenoException, LoginInvalidoException {
		this.gerentes.editar(login, map);
	}

	/**
	 * Remove um Gerente do repositório.
	 * @param login O login do Gerente a ser removido.
	 * @return Se havia um Gerente com o login dado.
	 * @throws LoginPequenoException Se o login tiver menos de 3 caracteres.
	 * @throws LoginInvalidoException Se o login conter caracteres inválidos.
	 */
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