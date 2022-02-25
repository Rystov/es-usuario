package com.global_hits.es.usuario.constants;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoEnum {

	AMIGOS("AMIGOS"),

	DOMICILIO("DOMICILIO"),

	MOVIL("MOVIL"),

	OTROS("OTROS"),

	FAMILIARES("FAMILIARES"),

	TRABAJO("TRABAJO"),

	VECINOS("VECINOS"),

	VACIO("");

	private String value;

	TipoEnum(String value) {
		this.value = value;
	}

	@JsonValue
	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}

}
