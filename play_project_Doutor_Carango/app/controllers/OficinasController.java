package controllers;

import play.mvc.Controller;
import play.mvc.Result;

import model.entidade.Oficina;
import model.negocio.Fachada;

import javax.inject.Inject;
import javax.inject.Singleton;

import views.html.oficinas.*;

@Singleton
public class OficinasController extends Controller {

	private final Fachada fachada;

	@Inject
	public OficinasController() {
		this.fachada = Fachada.getInstance();
	}

	public Result index() {
		Oficina[] oficinas = this.fachada.listarOficinas();
		return ok(indiceOficinas.render(oficinas));
	}
	
	public Result adicaoOficina() {
		fachada.cadastrarOficina(new Oficina("Optimus", "Cybertron", 0));
		return ok("Oficina \"Optimus\" cadastrada");
	}
	
	public Result infoOficina(String nome) {
		Oficina oficina = fachada.buscarOficina(nome);
		if (oficina == null)
			return ok(oficinaNaoExiste.render(nome));
		return ok(infoOficina.render(nome, oficina.getEndereco()));
	}
	
	public Result remocaoOficina(String login) {
		if (fachada.removerOficina(login))
			return ok(remocaoOficinaSucesso.render(login));
		return ok(oficinaNaoExiste.render(login));
	}

}
