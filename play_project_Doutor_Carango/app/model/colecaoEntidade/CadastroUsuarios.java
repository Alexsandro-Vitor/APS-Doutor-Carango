package model.colecaoEntidade;

import java.util.Map;
import java.util.HashMap;

import model.entidade.Usuario;

/**
 * Repositório no qual os Usuarios são armazenados na memória. Não é persistente.
 */
public abstract class CadastroUsuarios {
	private Map<String, Usuario> usuarios;

	public CadastroUsuarios() {
		this.usuarios = new HashMap<String, Usuario>();
	}

	/**
	 * Gera um array com todos os Usuarios do repositório.
	 * @return Todos os usuarios em um array.
	 */
	Usuario[] listar() {
		Usuario[] saida = new Usuario[this.usuarios.size()];
		int i = 0;
		for (String key : this.usuarios.keySet()) {
			saida[i++] = this.usuarios.get(key);
		}
		return saida;
	}

	/**
	 * Cadastra um Usuario novo.
	 * @param usuario O novo Usuario.
	 */
	void cadastrar(Usuario usuario) {
		this.usuarios.put(usuario.getLogin(), usuario);
	}

	/**
	 * Busca um Usuario.
	 * @param login O login do Usuario buscado.
	 * @return O Usuario com o login dado.
	 */
	Usuario buscar(String login) {
		return this.usuarios.get(login);
	}

	/**
	 * Remove um Usuario.
	 * @param nome O login do Usuario buscado.
	 */
	void remover(String login) {
		this.usuarios.remove(login);
	}
}