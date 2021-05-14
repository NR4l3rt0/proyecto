package com.jubiter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * Clase con la que arranca el proyecto, la anotación comentada @EnableWebSecurity, 
 * forma parte del módulo de seguridad.
 * Se puede hacer una comprobación realizando unos pequeños ajustes al proyecto y usando
 * el controlador {@link com.jubiter.controlador.SeguridadControlador}
 * 
 * 
 * @author nr_alberto
 * @version 1.0
 * 
 */
//@EnableWebSecurity
@SpringBootApplication
public class ProyectoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}

}
