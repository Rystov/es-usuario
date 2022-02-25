package com.global_hits.es.usuario.utils;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DataSourceConfig {

	@Bean(name = "customDataSource")
	@ConfigurationProperties("spring.datasource")
	public DataSource customDataSource() {
		return DataSourceBuilder.create().build();
	}

}

