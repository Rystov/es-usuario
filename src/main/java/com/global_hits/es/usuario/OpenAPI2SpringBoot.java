package com.global_hits.es.usuario;

import org.openapitools.jackson.nullable.JsonNullableModule;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.Module;

@SpringBootApplication
@ComponentScan(basePackages = { "com.global_hits.es.usuario", "com.global_hits.es.usuario.controller.impl",
		"com.global_hits.es.usuario.utils" })
public class OpenAPI2SpringBoot implements CommandLineRunner {

	@Override
	public void run(String... arg0) throws Exception {
		if (arg0.length > 0 && "exitcode".equals(arg0[0])) {
			throw new ExitException();
		}
	}

	public static void main(String[] args) throws Exception {
		new SpringApplication(OpenAPI2SpringBoot.class).run(args);
	}

	static class ExitException extends RuntimeException implements ExitCodeGenerator {
		private static final long serialVersionUID = 1L;
		private static final int EXIT_CODE = 10;

		@Override
		public int getExitCode() {
			return EXIT_CODE;
		}

	}

	@Bean
	public WebMvcConfigurer webConfigurer() {
		return new WebMvcConfigurer() {
			
		};
	}

	@Bean
	public Module jsonNullableModule() {
		return new JsonNullableModule();
	}

}