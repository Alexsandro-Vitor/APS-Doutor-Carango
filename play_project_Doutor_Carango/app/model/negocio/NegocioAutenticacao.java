package model.negocio;

import model.entidade.Usuario;
import model.entidade.Cliente;
import model.entidade.Gerente;
import model.excecoes.SenhaIncorretaException;
import play.Logger;

public class NegocioAutenticacao {
	Usuario usuarioLogado;
	public NegocioAutenticacao() {}

	public void logar(Usuario usuario, String senha) throws SenhaIncorretaException {
		if (usuario.getSenha().equals(Cliente.hashing(senha, usuario.getLogin()))) {
			usuarioLogado = usuario;
		} else throw new SenhaIncorretaException();
	}

	public Usuario getLogado() {
		return this.usuarioLogado;
	}

	public Cliente getClienteLogado() {
		if (this.usuarioLogado instanceof Cliente) return (Cliente)this.usuarioLogado;
		else return null;
	}

	public Gerente getGerenteLogado() {
		if (this.usuarioLogado instanceof Gerente) return (Gerente)this.usuarioLogado;
		else return null;
	}

	public void deslogar() {
		this.usuarioLogado = null;
	}
}