package model.negocio;

import model.entidade.Cliente;
import model.excecoes.LoginJaExisteException;
import model.excecoes.LoginPequenoException;
import model.excecoes.NomeVazioException;
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

	public void cadastrar(Cliente cliente) throws LoginPequenoException, NomeVazioException,
			SenhaPequenaException, LoginJaExisteException {
		if (cliente.getLogin() == null || cliente.getLogin().length() < LoginPequenoException.TAM_MINIMO)
			throw new LoginPequenoException();
		if (cliente.getNome() == null || cliente.getNome().length() == 0)
			throw new NomeVazioException();
		if (cliente.tamSenha() < SenhaPequenaException.TAM_MINIMO)
			throw new SenhaPequenaException();
		if (this.cadastro.buscar(cliente.getLogin()) != null)
			throw new LoginJaExisteException();
		
		this.cadastro.cadastrar(cliente);
	}

	public Cliente buscar(String login) {
		return this.cadastro.buscar(login);
	}

	public boolean remover(String login) {
		boolean saida = this.cadastro.buscar(login) != null;
		this.cadastro.remover(login);
		return saida;
	}
}