public class Fachada {
	private ControladorClientes clientes;
	private ControladorOficinas oficinas;

	public Fachada() {
		clientes = new ControladorClientes();
		oficinas = new ControladorOficinas();
	}

	public void cadastrarCliente(String nome, String login, String senha) {
		this.clientes.cadastrar(new Cliente(nome, login, senha));
	}

	public Cliente buscarCliente(String login) {
		return this.clientes.buscar(login);
	}

	public void removerCliente(String login) {
		this.clientes.remover(login);
	}

	public void cadastrarOficina(String nome, String endereco) {
		this.clientes.cadastrar(new Oficina(nome, endereco, 0));
	}

	public Cliente buscarOficina(String nome) {
		return this.clientes.buscar(nome);
	}

	public void removerOficina(String nome) {
		this.clientes.remover(nome);
	}
}