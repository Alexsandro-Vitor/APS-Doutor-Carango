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
		return ok(indiceOficinas.render(oficinas));
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
	
	public Result infoOficina(String nome) {
		Oficina oficina = fachada.buscarOficina(nome);
		if (oficina == null)
			return ok(oficinaNaoExiste.render(nome));
		return ok(infoOficina.render(nome, oficina.getEndereco()));
	}

	public Result edicaoOficina(String nome) {
		return TODO;
	}

	public Result editarOficina(String nome) {
		return TODO;
	}

	public Result remocaoOficina(String login) {
		if (fachada.removerOficina(login))
			return ok(remocaoOficinaSucesso.render(login));
		return ok(oficinaNaoExiste.render(login));
	}

}
