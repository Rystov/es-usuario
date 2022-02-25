package com.global_hits.es.usuario.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author fobregon
 *
 */
public enum TipoIdentificacionEnum {

	CED("CEDULA"), PAS("PASAPORTE"), EXT("EXTERIOR"), EXP("EXPEDIENTE"), RUC("RUC"), VISA("VISA"), OTRO("OTRO");

	private String value;

	TipoIdentificacionEnum(String value) {
		this.value = value;
	}

	@JsonValue
	public String getValue() {
		return value;
	}

	@JsonCreator
	public static TipoIdentificacionEnum fromValue(String value) {
		for (TipoIdentificacionEnum b : TipoIdentificacionEnum.values()) {
			if (b.value.equals(value)) {
				return b;
			}
		}
		return null;
	}

	@JsonCreator
	public static String obtenerValores() {
		StringBuilder elementos = new StringBuilder();
		for (TipoIdentificacionEnum b : TipoIdentificacionEnum.values()) {
			elementos.append(b.value.concat(", "));
		}
		return elementos.toString();
	}
}
