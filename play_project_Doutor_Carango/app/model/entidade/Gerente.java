package model.entidade;

import java.util.Map;

public class Gerente extends Usuario {
	public Gerente() {}

	/**
	 * Construtor por Map de Strings.
	 * @param map - O Map com valores para as chaves "Nome", "Login" e "Senha".
	 */
	public Gerente(Map<String, String> map) {
		super(map);
	}
}