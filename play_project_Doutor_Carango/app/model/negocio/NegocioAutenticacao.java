package model.negocio;

import model.entidade.Cliente;
import model.excecoes.SenhaIncorretaException;
import play.Logger;

public class NegocioAutenticacao {
	Cliente clienteLogado;
	public NegocioAutenticacao() {}

	public void logar(Cliente cliente, String senha) throws SenhaIncorretaException {
		if (cliente.getSenha().equals(Cliente.hashing(senha, cliente.getLogin()))) {
			clienteLogado = cliente;
		} else throw new SenhaIncorretaException();
	}

	public Cliente getLogado() {
		return this.clienteLogado;
	}

	public void deslogar() {
		clienteLogado = null;
	}
}