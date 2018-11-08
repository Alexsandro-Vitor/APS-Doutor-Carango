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
import views.html.erros.ErroOperacaoFalhou;

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
		return ok(indiceClientes.render(fachada.logado(), clientes));
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
		try {
			Cliente cliente = this.fachada.cadastrarCliente(form.rawData());
			return created(adicaoClienteSucesso.render(cliente.getLogin()));
		} catch (Exception e) {
			return badRequest(ErroOperacaoFalhou.render(
				e.getMessage(), "O cliente não pôde ser adicionado",
				"/clientes/adicao/", "Voltar à tela de Adicionar Clientes"));
		}
	}
	
	public Result infoCliente(String login) {
		try {
			Cliente cliente = fachada.buscarCliente(login);
			if (cliente == null)
				return notFound(clienteNaoExiste.render(login));
			return ok(infoCliente.render(cliente));
		} catch (Exception e) {
			return badRequest(ErroOperacaoFalhou.render(
				e.getMessage(), null, "/clientes/", "Voltar para a lista de Clientes"));
		}
	}

	public Result edicaoCliente(String login) {
		try {
			Cliente cliente = fachada.buscarCliente(login);
			if (cliente == null)
				return notFound(clienteNaoExiste.render(login));
			return ok(edicaoCliente.render(formFactory.form(Cliente.class), cliente));
		} catch (Exception e) {
			return badRequest(ErroOperacaoFalhou.render(
				e.getMessage(), null, "/clientes/", "Voltar para a lista de Clientes"));
		}
	}

	public Result editarCliente(String login) {
		Form<Cliente> form = formFactory.form(Cliente.class).bindFromRequest();
		Map<String, String> map = form.rawData();
		try {
			this.fachada.editarCliente(login, map);
			return this.ok(edicaoClienteSucesso.render(login));
		} catch (Exception e) {
			return unauthorized(ErroOperacaoFalhou.render(
				e.getMessage(), "O cliente não pôde ser atualizado",
				"/clientes/info/" + login + "/edit/", "Voltar à tela de Editar Clientes"));
		}
	}
	
	public Result remocaoCliente(String login) {
		try {
			if (fachada.removerCliente(login))
				return ok(remocaoClienteSucesso.render(login));
			return notFound(clienteNaoExiste.render(login));
		} catch (Exception e) {
			return badRequest(ErroOperacaoFalhou.render(
				e.getMessage(), "Não foi possível remover um cliente",
				"/clientes/", "Voltar para a lista de Clientes"));
		}
	}

}
