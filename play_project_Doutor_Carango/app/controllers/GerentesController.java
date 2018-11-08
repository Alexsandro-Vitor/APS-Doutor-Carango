package controllers;

import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import model.entidade.Gerente;
import model.negocio.Fachada;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import views.html.gerentes.*;
import views.html.erros.ErroOperacaoFalhou;

@Singleton
public class GerentesController extends Controller {

	private final Fachada fachada;

	@Inject FormFactory formFactory;

	@Inject
	public GerentesController() {
		this.fachada = Fachada.getInstance();
	}

	public Result index() {
		Gerente[] gerentes = this.fachada.listarGerentes();
		return ok(indiceGerentes.render(fachada.logado(), gerentes));
	}
	
	/**
	 * Gera a tela de adição de Gerentes.
	 * @return A tela de adição de Gerentes.
	 */
	public Result adicaoGerente() {
		return ok(adicaoGerente.render(formFactory.form(Gerente.class)));
	}

	/**
	 * Adiciona o Gerente com as informações da tela de adição de Gerentes.
	 * @return Um redirecionamento para outra tela.
	 */
	public Result adicionarGerente() {
		Form<Gerente> form = formFactory.form(Gerente.class).bindFromRequest();
		try {
			Gerente gerente = this.fachada.cadastrarGerente(form.rawData());
			return created(adicaoGerenteSucesso.render(gerente.getLogin()));
		} catch (Exception e) {
			return badRequest(ErroOperacaoFalhou.render(
				e.getMessage(), "O gerente não pôde ser adicionado",
				"/gerentes/adicao/", "Voltar à tela de Adicionar Gerentes"));
		}
	}
	
	public Result infoGerente(String login) {
		try {
			Gerente gerente = fachada.buscarGerente(login);
			if (gerente == null)
				return notFound(gerenteNaoExiste.render(login));
			return ok(infoGerente.render(gerente));
		} catch (Exception e) {
			return badRequest(ErroOperacaoFalhou.render(
				e.getMessage(), null, "/gerentes/", "Voltar para a lista de Gerentes"));
		}
	}

	public Result edicaoGerente(String login) {
		try {
			Gerente gerente = fachada.buscarGerente(login);
			if (gerente == null)
				return notFound(gerenteNaoExiste.render(login));
			return ok(edicaoGerente.render(formFactory.form(Gerente.class), gerente));
		} catch (Exception e) {
			return badRequest(ErroOperacaoFalhou.render(
				e.getMessage(), null, "/gerentes/", "Voltar para a lista de Gerentes"));
		}
	}

	public Result editarGerente(String login) {
		Form<Gerente> form = formFactory.form(Gerente.class).bindFromRequest();
		Map<String, String> map = form.rawData();
		try {
			this.fachada.editarGerente(login, map);
			return this.ok(edicaoGerenteSucesso.render(login));
		} catch (Exception e) {
			return unauthorized(ErroOperacaoFalhou.render(
				e.getMessage(), "O gerente não pôde ser atualizado",
				"/gerentes/info/" + login + "/edit/", "Voltar à tela de Editar Gerentes"));
		}
	}
	
	public Result remocaoGerente(String login) {
		try {
			if (fachada.removerGerente(login))
				return ok(remocaoGerenteSucesso.render(login));
			return notFound(gerenteNaoExiste.render(login));
		} catch (Exception e) {
			return badRequest(ErroOperacaoFalhou.render(
				e.getMessage(), "Não foi possível remover um gerente",
				"/gerentes/", "Voltar para a lista de Gerentes"));
		}
	}

}
