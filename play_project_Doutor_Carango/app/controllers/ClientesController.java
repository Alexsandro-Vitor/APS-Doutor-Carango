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
	
	public Result adicaoCliente() {
		return ok(adicaoCliente.render(formFactory.form(Cliente.class)));
	}

	public Result adicionarCliente() {
		Form<Cliente> form = formFactory.form(Cliente.class);
		Map<String, String> data = form.rawData();
		String saida = "" + data.size();
		for (String key : data.keySet()) {
			saida += "<"+key+", "+data.get(key)+">";
		}
		return ok(clienteNaoExiste.render(saida));
		/*Cliente cliente = form.get();
		if (this.fachada.cadastrarCliente(cliente))
			return redirect(routes.ClientesController.index());
		return redirect(routes.HomeController.index());*/
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
