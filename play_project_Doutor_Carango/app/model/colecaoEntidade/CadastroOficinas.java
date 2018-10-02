package model.colecaoEntidade;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ListIterator;

import model.entidade.Oficina;

public class CadastroOficinas {
	private ArrayList<Oficina> lista;

	public CadastroOficinas() {
		lista = new ArrayList();
	}

	/**
	 * Cadastra uma Oficina nova
	 * @param oficina A nova Oficina
	 */
	public void cadastrar(Oficina oficina) {
		this.lista.add(oficina);
	}
	
	/**
	 * Busca uma Oficina
	 * @param login O nome da Oficina buscada
	 * @return A Oficina com o nome dado
	 */
	public Oficina buscar(String nome) {
		ListIterator<Oficina> iterator = this.lista.listIterator();
		while (iterator.hasNext()) {
			Oficina temp = iterator.next();
			if (temp.getNome().equals(nome))
				return temp;
		}
		return null;
	}

	/**
	 * Remove uma Oficina
	 * @param nome O login da Oficina buscada
	 */
	public void remover(String nome) {
		ListIterator<Oficina> iterator = this.lista.listIterator();
		while (iterator.hasNext()) {
			if (iterator.next().getNome().equals(nome))
				iterator.remove();
		}
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