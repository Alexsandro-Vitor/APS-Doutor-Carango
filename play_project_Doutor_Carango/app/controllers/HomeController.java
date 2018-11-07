package controllers;

import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import play.Logger;

import model.negocio.Fachada;

import javax.inject.Inject;
import javax.inject.Singleton;

import views.html.*;
import views.html.erros.ErroOperacaoFalhou;

public class HomeController extends Controller {

	private final Fachada fachada;

	@Inject FormFactory formFactory;

	@Inject
	public HomeController() {
		this.fachada = Fachada.getInstance();
	}

	public Result index() {
		return ok(index.render(fachada.logado()));
	}
	
	public Result login() {
		return ok(login.render(formFactory.form(Object.class)));
	}

	public Result logar() {
		Form<Object> form = formFactory.form(Object.class).bindFromRequest();
		try {
			this.fachada.logar(form.rawData());
			return ok(index.render(fachada.logado()));
		} catch (Exception e) {
			return badRequest(ErroOperacaoFalhou.render(
				e.getMessage(), "O login falhou", "/login/", "Voltar à tela de login"));
		}
	}
}