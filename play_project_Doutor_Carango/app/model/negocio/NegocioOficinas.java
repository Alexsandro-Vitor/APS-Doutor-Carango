package model.negocio;

import model.entidade.Oficina;
import model.interfaces.IRepositorioOficinas;
import model.colecaoEntidade.CadastroOficinas;

public class NegocioOficinas {
	private IRepositorioOficinas cadastro;
	private int proxId;

	public NegocioOficinas() {
		cadastro = new CadastroOficinas();
		proxId = 0;
	}

	public Oficina[] listar() {
		return this.cadastro.listar();
	}

	public void cadastrar(Oficina oficina) {
		oficina.setId(this.proxId);
		this.proxId++;
		this.cadastro.cadastrar(oficina);
	}

	public Oficina buscar(String nome) {
		return this.cadastro.buscar(nome);
	}

	public boolean remover(String nome) {
		boolean saida = this.cadastro.buscar(nome) != null;
		this.cadastro.remover(nome);
		return saida;
	}
}