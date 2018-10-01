package model.negocio;

import java.util.ArrayList;

import javax.inject.*;

import model.entidade.Cliente;
import model.colecaoEntidade.CadastroClientes;

public class ControladorLogin {
	private CadastroClientes cadastro;
	private ArrayList<Cliente> sessoes;
	private int numSessoes;

	public ControladorLogin() {
		cadastro = new CadastroClientes();
		sessoes = new ArrayList();
		numSessoes = 0;
	}

	/**
	 * Tenta logar com o login e a senha dados
	 * @param login O login do Cliente
	 * @param senha A senha do Cliente
	 * @return Um ID de acesso, ou -1, se falhar
	 */
	public int efetuarLogin(String login, String senha) {
		if (validacaoLogin(login, senha)) {
			sessoes.add(this.cadastro.buscar(login));
			return numSessoes;
		}
		return -1;
	}

	private boolean validacaoLogin(String login, String senha) {
		Cliente cliente = this.cadastro.buscar(login);
		return cliente != null
			&& cliente.getSenha().equals(senha);
	}
}