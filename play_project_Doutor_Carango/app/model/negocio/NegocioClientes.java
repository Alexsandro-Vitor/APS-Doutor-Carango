package model.negocio;

import java.util.Map;

import model.entidade.Cliente;
import model.excecoes.LoginJaExisteException;
import model.excecoes.LoginPequenoException;
import model.excecoes.NomeInvalidoException;
import model.excecoes.LoginInvalidoException;
import model.excecoes.NomeVazioException;
import model.excecoes.SenhaIncorretaException;
import model.excecoes.SenhaInvalidaException;
import model.excecoes.SenhaPequenaException;
import model.interfaces.IRepositorioClientes;
import model.colecaoEntidade.CadastroClientes;

public class NegocioClientes {
	private IRepositorioClientes cadastro;

	public NegocioClientes() {
		cadastro = new CadastroClientes();
	}

	public Cliente[] listar() {
		return this.cadastro.listar();
	}

	public void cadastrar(Cliente cliente) throws LoginPequenoException, LoginInvalidoException,
			NomeVazioException, NomeInvalidoException, SenhaPequenaException, SenhaInvalidaException,
			LoginJaExisteException {
		validarLoginAdicao(cliente.getLogin());
		validarNome(cliente.getNome());
		validarSenhaCliente(cliente);

		this.cadastro.cadastrar(cliente);
	}

	public Cliente buscar(String login) throws LoginPequenoException, LoginInvalidoException {
		validarLogin(login);
		return this.cadastro.buscar(login);
	}

	public void editar(String login, Map<String, String> map) throws NomeInvalidoException,
			NomeVazioException, SenhaIncorretaException, SenhaPequenaException, SenhaInvalidaException,
			LoginPequenoException, LoginInvalidoException {
		validarLogin(login);
		Cliente cliente = this.cadastro.buscar(login);
		if (!cliente.checkSenha(map.get("Senha Atual")))
			throw new SenhaIncorretaException();

		String nome = map.get("Nome");
		if (nome != null) validarNome(nome);
		String senha = map.get("Nova Senha");
		if (senha != null) validarSenha(senha);

		cliente.setNome(map.get("Nome"));
		cliente.setSenha(senha);
	}

	public boolean remover(String login) throws LoginPequenoException, LoginInvalidoException {
		validarLogin(login);

		boolean saida = this.cadastro.buscar(login) != null;
		this.cadastro.remover(login);
		return saida;
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
		if (nome == null || nome.length() == 0)
			throw new NomeVazioException();
		if (!nome.matches(NomeInvalidoException.REGEX_NOME))
			throw new NomeInvalidoException();
	}

	private void validarSenha(String senha) throws SenhaPequenaException, SenhaInvalidaException {
		if (senha.length() < SenhaPequenaException.TAM_MINIMO)
			throw new SenhaPequenaException();
		if (!senha.matches(SenhaInvalidaException.REGEX_SENHA))
			throw new SenhaInvalidaException();
	}

	private void validarSenhaCliente(Cliente cliente) throws SenhaPequenaException, SenhaInvalidaException {
		if (cliente.tamSenha() < SenhaPequenaException.TAM_MINIMO)
			throw new SenhaPequenaException();
		if (!cliente.validarSenha(SenhaInvalidaException.REGEX_SENHA))
			throw new SenhaInvalidaException();
	}
}