package model.negocio;

import java.util.Map;

import model.entidade.Cliente;
import model.excecoes.LoginJaExisteException;
import model.excecoes.LoginPequenoException;
import model.excecoes.NomeInvalidoException;
import model.excecoes.LoginInvalidoException;
import model.excecoes.NomeVazioException;
import model.excecoes.SenhaIncorretaException;
import model.excecoes.SenhaPequenaException;
import model.interfaces.IRepositorioClientes;
import model.colecaoEntidade.CadastroClientes;

/**
 * Classe responsável por tratar as entradas para o repositório de Clientes.
 */
public class NegocioClientes {
	private IRepositorioClientes cadastro;

	public NegocioClientes() {
		cadastro = new CadastroClientes();
	}

	/**
	 * Gera um array com todos os Clientes do repositório.
	 * @return Todos os clientes em um array.
	 */
	public Cliente[] listar() {
		return this.cadastro.listar();
	}

	/**
	 * Cadastra um Cliente novo.
	 * @param cliente Os dados do novo Cliente.
	 * @throws LoginPequenoException Se o login tiver menos de 3 caracteres.
	 * @throws LoginInvalidoException Se o login conter caracteres inválidos.
	 * @throws NomeVazioException Se o nome não for preenchido.
	 * @throws NomeInvalidoException Se o nome conter caracteres inválidos.
	 * @throws SenhaPequenaException Se a senha tiver menos de 4 caracteres.
	 * @throws LoginJaExisteException Se já existe um Cliente com esse nome.
	 * @return O novo Cliente.
	 */
	public Cliente cadastrar(Map<String, String> cliente) throws LoginPequenoException,
			LoginInvalidoException, NomeVazioException, NomeInvalidoException,
			SenhaPequenaException, LoginJaExisteException {
		validarLoginAdicao(cliente.get("Login"));
		validarNome(cliente.get("Nome"));
		validarSenha(cliente.get("Senha"));

		Cliente saida = new Cliente(cliente);
		this.cadastro.cadastrar(saida);
		return saida;
	}

	/**
	 * Busca um Cliente no repositório.
	 * @param login O login do Cliente buscado.
	 * @return O Cliente que possui aquele login, se ele não existir, retorna null.
	 * @throws LoginPequenoException Se o login tiver menos de 3 caracteres.
	 * @throws LoginInvalidoException Se o login conter caracteres inválidos.
	 */
	public Cliente buscar(String login) throws LoginPequenoException, LoginInvalidoException {
		validarLogin(login);
		return this.cadastro.buscar(login);
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
	public void editar(String login, Map<String, String> map) throws NomeVazioException, 
			NomeInvalidoException, SenhaIncorretaException, SenhaPequenaException,
			LoginPequenoException, LoginInvalidoException {
		validarLogin(login);
		Cliente cliente = this.cadastro.buscar(login);
		if (!cliente.getSenha().equals(Cliente.hashing(map.get("Senha Atual"), login)))
			throw new SenhaIncorretaException();

		String nome = map.get("Nome");
		if (!nullOrEmpty(nome)) validarNome(nome);
		String senha = map.get("Nova Senha");
		if (!nullOrEmpty(senha)) validarSenha(senha);

		if (!nullOrEmpty(nome)) cliente.setNome(nome);
		if (!nullOrEmpty(senha)) cliente.setSenha(senha);
	}

	/**
	 * Remove um Cliente do repositório.
	 * @param login O login do Cliente a ser removido.
	 * @return Se havia um Cliente com o login dado.
	 * @throws LoginPequenoException Se o login tiver menos de 3 caracteres.
	 * @throws LoginInvalidoException Se o login conter caracteres inválidos.
	 */
	public boolean remover(String login) throws LoginPequenoException, LoginInvalidoException {
		validarLogin(login);

		boolean saida = this.cadastro.buscar(login) != null;
		this.cadastro.remover(login);
		return saida;
	}

	/**
	 * Checa se a String é nula ou vazia.
	 * @param s A String a ser checada.
	 * @return true se s == null ou s.length() == 0, false caso contrário.
	 */
	private boolean nullOrEmpty(String s) {
		return s == null || s.isEmpty();
	}

	private void validarLogin(String login) throws LoginPequenoException, LoginInvalidoException {
		if (login == null || login.length() < LoginPequenoException.TAM_MINIMO)
			throw new LoginPequenoException();
		if (!login.matches(LoginInvalidoException.REGEX_LOGIN))
			throw new LoginInvalidoException();
	}

	private void validarLoginAdicao(String login) throws LoginPequenoException,
			LoginInvalidoException, LoginJaExisteException {
		validarLogin(login);
		if (this.cadastro.buscar(login) != null)
			throw new LoginJaExisteException();
	}

	private void validarNome(String nome) throws NomeVazioException, NomeInvalidoException {
		if (nullOrEmpty(nome))
			throw new NomeVazioException();
		if (!nome.matches(NomeInvalidoException.REGEX_NOME))
			throw new NomeInvalidoException();
	}

	private void validarSenha(String senha) throws SenhaPequenaException {
		if (senha.length() < SenhaPequenaException.TAM_MINIMO)
			throw new SenhaPequenaException();
	}
}