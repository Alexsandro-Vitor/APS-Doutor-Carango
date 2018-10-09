package model.interfaces;

import model.entidade.Cliente;

public interface IRepositorioClientes {
	Cliente[] listar();
	void cadastrar(Cliente cliente);
	Cliente buscar(String login);
	void remover(String login);
}