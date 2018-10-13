package controllers;

import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import model.entidade.Cliente;
import model.negocio.Fachada;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import views.html.clientes.*;

@Singleton
public class ClientesController extends Controller {

	private final Fachada fachada;

	@Inject FormFactory formFactory;

	@Inject
	public ClientesController() {
		this.fachada = Fachada.getInstance();
	}

	public Result index() {
		Cliente[] clientes = this.fachada.listarClientes();
		return ok(indiceClientes.render(clientes));
	}
	
	/**
	 * Gera a tela de adição de Clientes.
	 * @return A tela de adição de Clientes.
	 */
	public Result adicaoCliente() {
		return ok(adicaoCliente.render(formFactory.form(Cliente.class)));
	}

	/**
	 * Adiciona o Cliente com as informações da tela de adição de Clientes.
	 * @return Um redirecionamento para outra tela.
	 */
	public Result adicionarCliente() {
		Form<Cliente> form = formFactory.form(Cliente.class).bindFromRequest();
		Cliente cliente = new Cliente(form.rawData());
		if (this.fachada.cadastrarCliente(cliente))
			return created(adicaoClienteSucesso.render(cliente.getLogin()));
		return badRequest(adicaoClienteFalha.render("Erro desconhecido"));
	}
	
	public Result infoCliente(String login) {
		Cliente cliente = fachada.buscarCliente(login);
		if (cliente == null)
			return notFound(clienteNaoExiste.render(login));
		return ok(infoCliente.render(login, cliente.getNome()));
	}
	
	public Result remocaoCliente(String login) {
		if (fachada.removerCliente(login))
			return ok(remocaoClienteSucesso.render(login));
		return notFound(clienteNaoExiste.render(login));
	}

}
