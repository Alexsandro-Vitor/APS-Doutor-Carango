package model.colecaoEntidade;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

import model.entidade.Gerente;
import model.entidade.Usuario;
import model.interfaces.IRepositorioGerentes;

/**
 * Repositório no qual os Gerentes são armazenados na memória. Não é persistente.
 */
public class CadastroGerentes extends CadastroUsuarios implements IRepositorioGerentes {

	public CadastroGerentes() {
		super();
	}

	/**
	 * Gera um array com todos os Gerentes do repositório.
	 * @return Todos os gerentes em um array.
	 */
	public Gerente[] listar() {
		Usuario[] superSaida = super.listar();
		return Arrays.copyOf(superSaida, superSaida.length, Gerente[].class);
	}

	/**
	 * Cadastra um Gerente novo.
	 * @param gerente O novo Gerente.
	 */
	public void cadastrar(Gerente gerente) {
		super.cadastrar(gerente);
	}

	/**
	 * Busca um Gerente.
	 * @param login O login do Gerente buscado.
	 * @return O Gerente com o login dado.
	 */
	public Gerente buscar(String login) {
		return (Gerente)super.buscar(login);
	}

	/**
	 * Remove um Gerente.
	 * @param nome O login do Gerente buscado.
	 */
	public void remover(String login) {
		super.remover(login);
	}
}