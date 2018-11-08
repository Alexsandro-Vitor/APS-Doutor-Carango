package model.colecaoEntidade;

import java.util.Map;
import java.util.HashMap;

import model.entidade.Gerente;
import model.interfaces.IRepositorioGerentes;

/**
 * Repositório no qual os Gerentes são armazenados na memória. Não é persistente.
 */
public class CadastroGerentes implements IRepositorioGerentes {
	private Map<String, Gerente> gerentes;

	public CadastroGerentes() {
		this.gerentes = new HashMap<String, Gerente>();
	}

	/**
	 * Gera um array com todos os Gerentes do repositório.
	 * @return Todos os gerentes em um array.
	 */
	public Gerente[] listar() {
		Gerente[] saida = new Gerente[this.gerentes.size()];
		int i = 0;
		for (String key : this.gerentes.keySet()) {
			saida[i++] = this.gerentes.get(key);
		}
		return saida;
	}

	/**
	 * Cadastra um Gerente novo.
	 * @param gerente O novo Gerente.
	 */
	public void cadastrar(Gerente gerente) {
		this.gerentes.put(gerente.getLogin(), gerente);
	}

	/**
	 * Busca um Gerente.
	 * @param login O login do Gerente buscado.
	 * @return O Gerente com o login dado.
	 */
	public Gerente buscar(String login) {
		return this.gerentes.get(login);
	}

	/**
	 * Remove um Gerente.
	 * @param nome O login do Gerente buscado.
	 */
	public void remover(String login) {
		this.gerentes.remove(login);
	}
}