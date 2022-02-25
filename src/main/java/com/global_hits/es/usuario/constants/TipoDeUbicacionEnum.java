package com.global_hits.es.usuario.constants;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoDeUbicacionEnum {

	PERSONAL("PERSONAL"),

	FAX("FAX"),

	CONTESTADORA("CONTESTADORA"),

	INET("INET"),

	MODEMS("MODEMS"),

	OPERADORA("OPERADORA"),

	VACIO("");

	private String value;

	TipoDeUbicacionEnum(String value) {
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
