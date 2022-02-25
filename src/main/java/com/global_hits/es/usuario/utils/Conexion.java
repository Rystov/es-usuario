
package com.global_hits.es.usuario.utils;

import java.sql.Connection;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class Conexion {


	@Autowired
	DataSource dataSource;
	public Connection getConnection()  {
		try {
			return dataSource.getConnection();
		}

	 catch (Exception e) {
	} 
	
	
	
		return null;
	}

}
