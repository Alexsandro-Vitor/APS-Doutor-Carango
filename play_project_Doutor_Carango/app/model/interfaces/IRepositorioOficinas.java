package model.interfaces;

import model.entidade.Oficina;

public interface IRepositorioOficinas {
	Oficina[] listar();
	void cadastrar(Oficina oficina);
	Oficina buscar(int id);
	void remover(int id);
}