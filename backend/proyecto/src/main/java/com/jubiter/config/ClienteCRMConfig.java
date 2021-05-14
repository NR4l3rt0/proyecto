package com.jubiter.config;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jubiter.modelo.ClienteCRM;
import com.jubiter.repository.ClienteCRMRepository;

/**
 * Inicializa la tabla de los clientes en la BBDD. Se ayuda del repositorio.
 * 
 * @author nr_alberto
 *
 */
@Configuration
public class ClienteCRMConfig {

    @Bean("ClienteCRMConfig")
    CommandLineRunner commandLineRunnerClienteCRM (ClienteCRMRepository clienteCRMRepository) {

    	
    	return args -> {
    		clienteCRMRepository.saveAll(
				List.of(
	    			new ClienteCRM(LocalDate.now(), null, false, "", "Juan", "Vera", "667747474","juan@hotmail.com",  "Hombre", "Madrid",
	                        "soltero/-a","química", "camarero", "comida", LocalDate.parse("1987-12-29"), false),
	    			new ClienteCRM(LocalDate.now(), null, false, "", "Juana", "Vez", "637747474","juana@hotmail.com", "Mujer", "Madrid", 
	                        "soltero/-a","filóloga", "traductora", "mascotas", LocalDate.parse("1943-12-06"), true),
	    			new ClienteCRM(LocalDate.now(), null, true,   "", "Sebas", "Toledo", "627337224","sebas@hotmail.com",  "Hombre", "Málaga",
	                         "casado/-a","manager", "director hotel", "idiomas", LocalDate.parse("2000-12-22"), false),
	    			new ClienteCRM(LocalDate.now(),null, true,  "", "Loli", "Paz", "611337794", "loli@hotmail.com",   "Mujer", "Málaga",
	                         "soltero/-a","marketing", "empresaria", "cultura", LocalDate.parse("1991-01-11"), false),
	    			new ClienteCRM(LocalDate.now(), null,  true, "", "Pedro", "Núñez",  "688886624", "pedro@hotmail.com", "Hombre", "Sevilla",
	                         "casado/-a","manager", "director hotel", "idiomas", LocalDate.parse("1970-02-11"), true),
	    			new ClienteCRM(LocalDate.now(), null, false,  "", "Petra", "Willis", "627337004","petra.willis@hotmail.com", "Mujer", "Alicante",
	                         "casado/-a","manager", "director hotel", "idiomas", LocalDate.parse("1958-12-21"), true),
	    			new ClienteCRM(LocalDate.now(), null, true, "", "Miguel", "Cervantes",  "627337211", "cervantes@hotmail.com", "Hombre", "Bilbao",
	                         "casado/-a","derecho", "bibliotecario", "dibujar", LocalDate.parse("1993-12-16"), false)
				)
			);
    	};
    }
}