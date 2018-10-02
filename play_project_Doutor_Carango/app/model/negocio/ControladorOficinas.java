package model.negocio;

import java.util.ArrayList;

import javax.inject.*;

import model.entidade.Oficina;
import model.colecaoEntidade.CadastroOficinas;

public class ControladorOficinas {
	private CadastroOficinas cadastro;

	public ControladorOficinas() {
		cadastro = new CadastroOficinas();
	}

	public void cadastrar(Oficina oficina) {
		this.cadastro.cadastrar(oficina);
	}

	public Oficina buscar(String nome) {
		return this.cadastro.buscar(nome);
	}

	public void remover(String nome) {
		this.cadastro.remover(nome);
	}
}