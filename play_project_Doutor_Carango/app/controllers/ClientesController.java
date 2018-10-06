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
    public ClientesController(Fachada fachada) {
       this.fachada = fachada;
	}
	
	public Result adicaoCliente() {
		fachada.cadastrarCliente("A", "aaa", "1234");
		return ok("Cliente \"aaa\" cadastrado");
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
