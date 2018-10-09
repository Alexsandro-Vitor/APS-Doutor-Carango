package model.colecaoEntidade;

import java.util.Map;
import java.util.HashMap;

import model.entidade.Oficina;
import model.interfaces.IRepositorioOficinas;

public class CadastroOficinas implements IRepositorioOficinas {
	private Map<String, Oficina> oficinas;

	public CadastroOficinas() {
		this.oficinas = new HashMap<String, Oficina>();
	}
	
	public Oficina[] listar() {
		Oficina[] saida = new Oficina[this.oficinas.size()];
		int i = 0;
		for (String key : this.oficinas.keySet()) {
			saida[i++] = this.oficinas.get(key);
		}
		return saida;
	}
	
	/**
	 * Cadastra uma Oficina nova
	 * @param Oficina A nova Oficina
	 */
	public void cadastrar(Oficina oficina) {
		this.oficinas.put(oficina.getNome(), oficina);
	}

	/**
	 * Busca uma Oficina
	 * @param login O nome da Oficina buscada
	 * @return A Oficina com o nome dado
	 */
	public Oficina buscar(String nome) {
		return this.oficinas.get(nome);
	}

	/**
	 * Remove uma Oficina
	 * @param nome O login da Oficina buscada
	 */
	public void remover(String nome) {
		this.oficinas.remove(nome);
	}

	/**
	 * Ordena as oficinas por qualidade
	 * @return A lista de Oficinas ordenada por qualidade
	 
	public ArrayList<Oficina> buscarOficinasOrdenadasQualidade() {
		Collections.sort(this.lista, new Comparator<Oficina>() {
			public int compare(Oficina a, Oficina b) {
				if (a.getRankingQualidade() < b.getRankingQualidade()) return -1;
				else if (a.getRankingQualidade() > b.getRankingQualidade()) return 1;
				else return 0;
			}
		});
		return this.lista;
	}*/
}