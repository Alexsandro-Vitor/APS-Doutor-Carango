package controllers;

import play.mvc.Controller;
import play.mvc.Result;

import model.negocio.Fachada;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class OficinasController extends Controller {

    private final Fachada fachada;

    @Inject
    public OficinasController(Fachada fachada) {
       this.fachada = fachada;
	}
	
	public Result adicaoOficina() {
		fachada.cadastrarOficina("Optimus", "Cybertron");
		return ok("Oficina \"Optimus\" cadastrada");
	}
	
    public Result buscaOficina() {
        return ok(fachada.buscarOficina("Optimus").getEndereco());
	}
	
	public Result remocaoOficina() {
		fachada.removerCliente("Optimus");
		return ok("Oficina \"Optimus\" removida");
	}

}
