package com.global_hits.es.usuario.constants;

import com.fasterxml.jackson.annotation.JsonValue;

public enum OperadoraEnum {

	CNT("CNT"),

	CLARO("CLARO"),

	MOVISTAR("MOVISTAR"),

	VACIO("");

	private String value;

	OperadoraEnum(final String value) {
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
