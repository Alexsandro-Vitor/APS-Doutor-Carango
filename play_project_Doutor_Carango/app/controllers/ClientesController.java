package controllers;

import play.mvc.Controller;
import play.mvc.Result;

import model.negocio.Fachada;

import javax.inject.Inject;
import javax.inject.Singleton;

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
	
    public Result buscaCliente() {
        return ok(fachada.buscarCliente("aaa").getNome());
	}
	
	public Result remocaoCliente() {
		fachada.removerCliente("aaa");
		return ok("Cliente \"aaa\" removido");
	}

}
