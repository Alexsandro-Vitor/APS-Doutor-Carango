package model.negocio;

import model.entidade.Oficina;
import model.colecaoEntidade.CadastroOficinas;

public class NegocioOficinas {
	private CadastroOficinas cadastro;

	public NegocioOficinas() {
		cadastro = new CadastroOficinas();
	}

	public Oficina[] listar() {
		return this.cadastro.listar();
	}

	public void cadastrar(Oficina oficina) {
		this.cadastro.cadastrar(oficina);
	}

	public Oficina buscar(String nome) {
		return this.cadastro.buscar(nome);
	}

	public boolean remover(String nome) {
		return this.cadastro.remover(nome);
	}
}