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

	public Oficina buscar(int id) {
		return this.cadastro.buscar(id);
	}

	public boolean remover(int id) {
		boolean saida = this.cadastro.buscar(id) != null;
		this.cadastro.remover(id);
		return saida;
	}
}