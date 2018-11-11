package model.negocio;

import model.entidade.Usuario;
import model.entidade.Cliente;
import model.entidade.Gerente;
import model.excecoes.SenhaIncorretaException;

/**
 * Classe responsável por tratar a autenticacao dos Usuarios.
 */
public class NegocioAutenticacao {
	Usuario usuarioLogado;
	public NegocioAutenticacao() {}

	/**
	 * Autentica um Usuario.
	 * @param usuario O Usuario a ser logado.
	 * @param senha A senha a ser validada.
	 * @throws SenhaIncorretaException Se a senha dada estiver incorreta.
	 */
	public void logar(Usuario usuario, String senha) throws SenhaIncorretaException {
		if (usuario.getSenha().equals(Cliente.hashing(senha, usuario.getLogin()))) {
			usuarioLogado = usuario;
		} else throw new SenhaIncorretaException();
	}

	/**
	 * Obtem o Usuario logado.
	 * @return O Usuario logado.
	 */
	public Usuario getLogado() {
		return this.usuarioLogado;
	}

	/**
	 * Obtem o Usuario logado, se ele for um Cliente.
	 * @return O Cliente logado, se houver um.
	 */
	public Cliente getClienteLogado() {
		if (this.usuarioLogado instanceof Cliente) return (Cliente)this.usuarioLogado;
		else return null;
	}

	/**
	 * Obtem o Usuario logado, se ele for um Gerente.
	 * @return O Gerente logado, se houver um.
	 */
	public Gerente getGerenteLogado() {
		if (this.usuarioLogado instanceof Gerente) return (Gerente)this.usuarioLogado;
		else return null;
	}

	/**
	 * Desloga o Usuario atual.
	 */
	public void deslogar() {
		this.usuarioLogado = null;
	}
}