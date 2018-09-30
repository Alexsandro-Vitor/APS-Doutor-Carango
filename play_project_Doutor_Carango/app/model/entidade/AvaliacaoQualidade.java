package model.entidade;

public class AvaliacaoQualidade {
	private Cliente cliente;
	private Oficina oficina;
	private int nota;

	public AvaliacaoQualidade(Cliente cliente, Oficina oficina, int nota) {
		this.cliente = cliente;
		this.oficina = oficina;
		this.nota = nota;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public Oficina getOficina() {
		return this.oficina;
	}

	public int getNota() {
		return this.nota;
	}
}