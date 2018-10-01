package model.colecaoEntidade;

import java.util.ArrayList;

import model.entidade.Oficina;

public class CadastroOficinas {
	private ArrayList<Oficina> lista;

	public CadastroOficinas() {
		lista = new ArrayList();
	}

	public void cadastrar(Oficina oficina) {
		this.lista.add(oficina);
	}

	public ArrayList<Oficina> buscarOficinasOrdenadasQualidade() {
		// PARA FAZER
		return null;
	}
}