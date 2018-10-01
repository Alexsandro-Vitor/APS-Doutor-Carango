package model.colecaoEntidade;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import model.entidade.Oficina;

public class CadastroOficinas {
	private ArrayList<Oficina> lista;

	public CadastroOficinas() {
		lista = new ArrayList();
	}

	public void cadastrar(Oficina oficina) {
		this.lista.add(oficina);
	}

	/**
	 * Ordena as oficinas por qualidade
	 */
	public ArrayList<Oficina> buscarOficinasOrdenadasQualidade() {
		Collections.sort(this.lista, new Comparator<Oficina>() {
			public int compare(Oficina a, Oficina b) {
				if (a.getRankingQualidade() < b.getRankingQualidade()) return -1;
				else if (a.getRankingQualidade() > b.getRankingQualidade()) return 1;
				else return 0;
			}
		});
		return null;
	}
}