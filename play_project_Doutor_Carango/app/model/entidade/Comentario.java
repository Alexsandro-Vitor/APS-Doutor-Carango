package model.entidade;

public class Comentario {
	private Cliente cliente;
	private Oficina oficina;
	private String descricao;

	public Comentario(Cliente cliente, Oficina oficina, String descricao) {
		this.cliente = cliente;
		this.oficina = oficina;
		this.descricao = descricao;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public Oficina getOficina() {
		return this.oficina;
	}

	public String getDescricao() {
		return this.descricao;
	}
}