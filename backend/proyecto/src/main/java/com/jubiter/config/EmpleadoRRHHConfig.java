package com.jubiter.config;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import com.jubiter.modelo.EmpleadoRRHH;
import com.jubiter.repository.EmpleadoRRHHRepository;

/**
 * Inicializa la tabla de los empleados.
 * 
 * @author nr_alberto
 *
 */
@Configuration
public class EmpleadoRRHHConfig {

	@DependsOn("ClienteCRMConfig")
    @Bean("EmpleadoRRHHConfig")
    CommandLineRunner commandLineRunnerEmpleadoRRHH (EmpleadoRRHHRepository empleadoRRHHRepository) {

    	return args -> {
    		empleadoRRHHRepository.saveAll(
				List.of(
	    			new EmpleadoRRHH("Lara", "Pacheco", "664332194", "lara@hotmail.com", "Mujer", "Cádiz",
	                         "soltero/-a","INEF", "entrenadora", "correr", LocalDate.parse("1989-01-22"), true, 8,
	                         "12345678a", "transportista", "completa", 20000),
	    			new EmpleadoRRHH ("Jose", "Moreno", "611181121", "jose@hotmail.com", "Hombre", "Las Palmas",
	                         "casado/-a", "FP", "coordinador", "aviones", LocalDate.parse("1979-02-05"), true, 9,
	                         "21345678b", "coordinador", "flexible", 30000),
	    			new EmpleadoRRHH("Clara", "Díaz", "655537004", "clara.diaz@hotmail.com", "Mujer", "A coruña",
	                         "soltero/-a", "psicología", "dependiente", "vino", LocalDate.parse("1984-09-15"), false, 10,
	                         "3124678z", "administrativo", "parcial", 21000),
	    			new EmpleadoRRHH("Paul", "Lesly", "627330001", "gibson@hotmail.com", "Hombre", "Zaragoza",
	                         "casado/-a","ingeniaría", "estudiante", "meditar", LocalDate.parse("1996-11-25"), true, 11,
	                         "5123478y", "sop. técnico", "parcial", 19500)
				)
			);
    	};
    }
}
