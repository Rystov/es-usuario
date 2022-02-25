/**
 * 
 */
package com.global_hits.es.usuario.constants;

/**
 * @author rmoran
 *
 */
public final class UsuarioConstants {
	
	/* NOMBRE DE PROCEDIMIENTOS */
	public static final String PQCONCLI_IDENT = "{call MSCAPCLI_Cliente_PQCON."
			+ "PRCON_ClientePorIdentificacion(?,?,?,?,?,?)}";
	public static final String PQCONCLI_NUM = "{call MSCAPCLI_Cliente_PQCON.PRCON_ClientePorNumero(?,?,?,?,?)}";
	public static final String PQCONDIR_IDENT = "{call MSCAPCLI_Cliente_PQCON.PRCON_DirPorIdentificacion(?,?,?,?)}";
	public static final String PQCONFONO_IDENT = "{call MSCAPCLI_Cliente_PQCON.PRCON_TelPorIdentificacion(?,?,?)}";
	public static final String PRCONCLI_INCONSIST = "{call MSCAPCLI_Cliente_PQCON.prcon_valclienteinconsistente(?,?)}";
	/* NOMBRES CURSORES */
	public static final String CURSOR_RESULTADO = "pcurResultado";
	public static final String CURSOR_TELEFONOS = "pcurtelefonos";
	public static final String CURSOR_DIRECCIONES = "pcurDirecciones";
	public static final String CURSOR_EXTRA = "pinfoExtra";
	/* PARAMETROS IN OR OUT */
	public static final String PARAM_DES_VALIDACION = "pvDescValidacion";
	public static final String PARAM_IDENTIFICACION = "pvIdentificacion";
	public static final String PARAM_TIPO_IDENTIFICACION = "pvTipoDeIdentificacion";
	
	public static final String NO_HAY_DATOS = "No se encontraron datos";
	public static final String FUENTES_DATOS_MENSAJE = "No existen Datos";
	public static final String FUENTES_DATOS_DETALLE = "Dado los parametros ingresados no se ha encontrado "
			+ "la informacion solicitada";
	public static final String ERROR_INTERNO = "Error interno";
	
	public static final String FORMATO_TIEMPO = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
	
	public static final String DB_FALLO_CONEXION = "NO PUDIMOS OBTENER CONEXIÓN CON LA BASE DE DATOS" ;
	public static final String ERROR_SENTENCIA_SQL = "OCURRIO UN ERROR CON LA SENTENCIA SQL EJECUTADA";

	private UsuarioConstants() {
	}

	

}


