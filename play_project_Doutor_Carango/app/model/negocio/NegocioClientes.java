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
		if (cliente.getLogin() == null || cliente.getLogin().length() < LoginPequenoException.TAM_MINIMO)
			throw new LoginPequenoException();
		if (!cliente.getLogin().matches(LoginInvalidoException.REGEX_LOGIN))
			throw new LoginInvalidoException();
		if (cliente.getNome() == null || cliente.getNome().length() == 0)
			throw new NomeVazioException();
		if (!cliente.getNome().matches(NomeInvalidoException.REGEX_NOME))
			throw new NomeInvalidoException();
		if (cliente.tamSenha() < SenhaPequenaException.TAM_MINIMO)
			throw new SenhaPequenaException();
		if (!cliente.validarSenha(SenhaInvalidaException.REGEX_SENHA))
			throw new SenhaInvalidaException();
		if (this.cadastro.buscar(cliente.getLogin()) != null)
			throw new LoginJaExisteException();
		
		this.cadastro.cadastrar(cliente);
	}

	public Cliente buscar(String login) {
		return this.cadastro.buscar(login);
	}

	public void editar(String login, Map<String, String> map)
			throws SenhaIncorretaException, SenhaPequenaException {
		Cliente cliente = this.cadastro.buscar(login);
		if (!cliente.checkSenha(map.get("Senha Atual")))
			throw new SenhaIncorretaException();
		String senha = map.get("Nova Senha");
		if (senha == null || senha.length() < SenhaPequenaException.TAM_MINIMO)
			throw new SenhaPequenaException();

		cliente.setNome(map.get("Nome"));
		cliente.setSenha(senha);
	}

	public boolean remover(String login) {
		boolean saida = this.cadastro.buscar(login) != null;
		this.cadastro.remover(login);
		return saida;
	}
}