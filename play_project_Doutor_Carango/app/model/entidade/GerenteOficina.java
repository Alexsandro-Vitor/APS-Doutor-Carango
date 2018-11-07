package model.entidade;

import java.util.Map;

public class GerenteOficina extends Usuario {
	public GerenteOficina() {}

	/**
	 * Construtor por Map de Strings.
	 * @param map - O Map com valores para as chaves "Nome", "Login" e "Senha".
	 */
	public GerenteOficina(Map<String, String> map) {
		super(map);
	}
}