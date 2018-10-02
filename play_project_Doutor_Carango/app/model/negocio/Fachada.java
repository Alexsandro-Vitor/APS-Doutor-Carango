import model.entidade.Cliente;
import model.negocio.ControladorClientes;

import model.entidade.Oficina;
import model.negocio.ControladorOficinas;

public class Fachada {
	private ControladorClientes clientes;
	private ControladorOficinas oficinas;

	public Fachada() {
		clientes = new ControladorClientes();
		oficinas = new ControladorOficinas();
	}

	public void cadastrarCliente(String nome, String login, String senha) {
		this.clientes.cadastrar(new Cliente(nome, login, senha));
	}

	public Cliente buscarCliente(String login) {
		return this.clientes.buscar(login);
	}

	public void removerCliente(String login) {
		this.clientes.remover(login);
	}

	public void cadastrarOficina(String nome, String endereco) {
		this.oficinas.cadastrar(new Oficina(nome, endereco, 0));
	}

	public Oficina buscarOficina(String nome) {
		return this.oficinas.buscar(nome);
	}

	public void removerOficina(String nome) {
		this.oficinas.remover(nome);
	}
}