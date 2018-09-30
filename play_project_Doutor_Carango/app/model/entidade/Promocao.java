package model.entidade;

public class Promocao {
	private Oficina oficina;
	private String descricao;

	public Promocao(Oficina oficina, String descricao) {
		this.oficina = oficina;
		this.descricao = descricao;
	}

	public Oficina getOficina() {
		return this.oficina;
	}

	public String getDescricao() {
		return this.descricao;
	}
}