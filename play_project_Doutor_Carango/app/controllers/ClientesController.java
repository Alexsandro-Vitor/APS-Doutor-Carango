package controllers;

import play.mvc.Controller;
import play.mvc.Result;

import model.entidade.Cliente;
import model.negocio.Fachada;

import javax.inject.Inject;
import javax.inject.Singleton;

import views.html.clientes.*;

@Singleton
public class ClientesController extends Controller {

	private final Fachada fachada;

	@Inject
	public ClientesController() {
		this.fachada = Fachada.getInstance();
	}

	public Result index() {
		Cliente[] clientes = this.fachada.listarClientes();
		return ok(indiceClientes.render(clientes));
	}
	
	public Result adicaoCliente() {
		return ok(adicaoCliente.render());
	}
	
	public Result infoCliente(String login) {
		Cliente cliente = fachada.buscarCliente(login);
		if (cliente == null)
			return ok(clienteNaoExiste.render(login));
		return ok(infoCliente.render(login, cliente.getNome()));
	}
	
	public Result remocaoCliente(String login) {
		if (fachada.removerCliente(login))
			return ok(remocaoClienteSucesso.render(login));
		return ok(clienteNaoExiste.render(login));
	}

}
