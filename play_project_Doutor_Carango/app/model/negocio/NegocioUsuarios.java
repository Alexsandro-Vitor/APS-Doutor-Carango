package model.negocio;

import model.entidade.Usuario;
import model.excecoes.LoginJaExisteException;
import model.excecoes.LoginPequenoException;
import model.excecoes.NomeInvalidoException;
import model.excecoes.LoginInvalidoException;
import model.excecoes.NomeVazioException;
import model.excecoes.SenhaPequenaException;

/**
 * Classe que contém os métodos de validação para os repositórios de Usuarios.
 */
public abstract class NegocioUsuarios {
	abstract Usuario buscar(String login) throws LoginPequenoException, LoginInvalidoException;

	/**
	 * Checa se a String é nula ou vazia.
	 * @param s A String a ser checada.
	 * @return true se s == null ou s.length() == 0, false caso contrário.
	 */
	boolean nullOrEmpty(String s) {
		return s == null || s.isEmpty();
	}

	/**
	 * Valida o login recebido.
	 * @param login O login a ser validado.
	 * @throws LoginPequenoException Se o login tiver menos de 3 caracteres.
	 * @throws LoginInvalidoException Se o login conter caracteres inválidos.
	 */
	void validarLogin(String login) throws LoginPequenoException, LoginInvalidoException {
		if (login == null || login.length() < LoginPequenoException.TAM_MINIMO)
			throw new LoginPequenoException();
		if (!login.matches(LoginInvalidoException.REGEX_LOGIN))
			throw new LoginInvalidoException();
	}

	/**
	 * Valida o login recebido para uma operação de adição.
	 * @param login O login a ser validado.
	 * @throws LoginPequenoException Se o login tiver menos de 3 caracteres.
	 * @throws LoginInvalidoException Se o login conter caracteres inválidos.
	 * @throws LoginJaExisteException Se já existe um Cliente com esse nome.
	 */
	void validarLoginAdicao(String login) throws LoginPequenoException,
			LoginInvalidoException, LoginJaExisteException {
		validarLogin(login);
		if (this.buscar(login) != null)
			throw new LoginJaExisteException();
	}

	/**
	 * Valida o nome recebido.
	 * @param nome O nome a ser validado.
	 * @throws NomeVazioException Se o nome não for preenchido.
	 * @throws NomeInvalidoException Se o nome conter caracteres inválidos.
	 */
	void validarNome(String nome) throws NomeVazioException, NomeInvalidoException {
		if (nullOrEmpty(nome))
			throw new NomeVazioException();
		if (!nome.matches(NomeInvalidoException.REGEX_NOME))
			throw new NomeInvalidoException();
	}

	/**
	 * Valida a senha recebida.
	 * @param senha A senha a ser validada.
	 * @throws SenhaPequenaException Se a senha tiver menos de 4 caracteres.
	 */
	void validarSenha(String senha) throws SenhaPequenaException {
		if (senha.length() < SenhaPequenaException.TAM_MINIMO)
			throw new SenhaPequenaException();
	}
}