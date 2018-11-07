package controllers;

import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import model.entidade.Oficina;
import model.negocio.Fachada;

import javax.inject.Inject;
import javax.inject.Singleton;

import views.html.oficinas.*;
import views.html.erros.ErroOperacaoFalhou;

@Singleton
public class OficinasController extends Controller {

	private final Fachada fachada;

	@Inject FormFactory formFactory;

	@Inject
	public OficinasController() {
		this.fachada = Fachada.getInstance();
	}

	public Result index() {
		Oficina[] oficinas = this.fachada.listarOficinas();
		return ok(indiceOficinas.render(fachada.logado(), oficinas));
	}

	public Result adicaoOficina() {
		return ok(adicaoOficina.render(formFactory.form(Oficina.class)));
	}

	public Result adicionarOficina() {
		Form<Oficina> form = formFactory.form(Oficina.class).bindFromRequest();
		Oficina oficina = new Oficina(form.rawData());
		try {
			this.fachada.cadastrarOficina(oficina);
			return created(adicaoOficinaSucesso.render(oficina.getNome()));
		} catch (Exception e) {
			return badRequest(ErroOperacaoFalhou.render(
				e.getMessage(), "A oficina não pôde ser adicionada",
				"/oficinas/adicao/", "Voltar à tela de Adicionar Oficinas"));
		}
	}

	public Result infoOficina(int id) {
		try {
			Oficina oficina = fachada.buscarOficina(id);
			if (oficina == null)
				return notFound(oficinaNaoExiste.render(id));
			return ok(infoOficina.render(fachada.logado(), oficina));
		} catch (Exception e) {
			return badRequest(ErroOperacaoFalhou.render(
				e.getMessage(), null, "/oficinas/", "Voltar para a lista de Oficinas"));
		}
	}

	public Result avaliacaoOficina(int id) {
		return TODO;
	}

	public Result avaliarOficina(int id) {
		return TODO;
	}

	public Result edicaoOficina(int id) {
		Oficina oficina = fachada.buscarOficina(id);
		if (oficina == null)
			return notFound(oficinaNaoExiste.render(id));
		return ok(edicaoOficina.render(formFactory.form(Oficina.class), oficina));
	}

	public Result editarOficina(int id) {
		return TODO;
	}

	public Result remocaoOficina(int id) {
		if (fachada.removerOficina(id))
			return ok(remocaoOficinaSucesso.render(id));
		return ok(oficinaNaoExiste.render(id));
	}
}