package model.entidade;

import java.util.HashMap;
import java.util.Map;

public class Oficina {
	private String nome;
	private String endereco;
	private int id;
	private Gerente gerente;
	private Map<String, Integer> avaliacoesAgilidade;
	private Map<String, Integer> avaliacoesPreco;
	private Map<String, Integer> avaliacoesQualidade;

	public Oficina() {}

	public Oficina(String nome, String endereco, Gerente gerente) {
		this.nome = nome;
		this.endereco = endereco;
		this.gerente = gerente;
		this.avaliacoesAgilidade = new HashMap<String, Integer>();
		this.avaliacoesPreco = new HashMap<String, Integer>();
		this.avaliacoesQualidade = new HashMap<String, Integer>();
	}

	public Oficina(Map<String, String> map) {
		this.nome = map.get("Nome");
		this.endereco = map.get("Endereco");
		this.avaliacoesAgilidade = new HashMap<String, Integer>();
		this.avaliacoesPreco = new HashMap<String, Integer>();
		this.avaliacoesQualidade = new HashMap<String, Integer>();
	}

	public String getNome() {
		return this.nome;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Gerente getGerente() {
		return this.gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}

	public int getNotaAgilidade() {
		if (avaliacoesAgilidade.isEmpty()) return -1;
		int saida = 0;
		for (String key : avaliacoesAgilidade.keySet())
			saida += avaliacoesAgilidade.get(key);
		return saida / avaliacoesAgilidade.size();
	}

	public String showNotaAgilidade() {
		if (avaliacoesAgilidade.isEmpty()) return "Sem Avaliações";
		else return "" + this.getNotaAgilidade();
	}

	public int getNotaPreco() {
		if (avaliacoesPreco.isEmpty()) return -1;
		int saida = 0;
		for (String key : avaliacoesPreco.keySet())
			saida += avaliacoesPreco.get(key);
		return saida / avaliacoesPreco.size();
	}

	public String showNotaPreco() {
		if (avaliacoesPreco.isEmpty()) return "Sem Avaliações";
		else return "" + this.getNotaPreco();
	}

	public int getNotaQualidade() {
		if (avaliacoesQualidade.isEmpty()) return -1;
		int saida = 0;
		for (String key : avaliacoesQualidade.keySet())
			saida += avaliacoesQualidade.get(key);
		return saida / avaliacoesQualidade.size();
	}

	public String showNotaQualidade() {
		if (avaliacoesQualidade.isEmpty()) return "Sem Avaliações";
		else return "" + this.getNotaQualidade();
	}

	public void addAvaliacao(String login, Map<String, String> map) {
		avaliacoesAgilidade.put(login, Integer.parseInt(map.get("Agilidade")));
		avaliacoesPreco.put(login, Integer.parseInt(map.get("Preco")));
		avaliacoesQualidade.put(login, Integer.parseInt(map.get("Qualidade")));
	}
}