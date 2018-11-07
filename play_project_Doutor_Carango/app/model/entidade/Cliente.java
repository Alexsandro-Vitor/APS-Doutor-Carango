package model.entidade;

import java.util.Map;

public class Cliente extends Usuario {
	public Cliente() {}

	/**
	 * Construtor por Map de Strings.
	 * @param map - O Map com valores para as chaves "Nome", "Login" e "Senha".
	 */
	public Cliente(Map<String, String> map) {
		super(map);
	}
}