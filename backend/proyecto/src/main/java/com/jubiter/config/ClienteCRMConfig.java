package com.jubiter.config;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jubiter.modelo.ClienteCRM;
import com.jubiter.repository.ClienteCRMRepository;

@Configuration
public class ClienteCRMConfig {

    @Bean
    CommandLineRunner commandLineRunnerClienteCRM (ClienteCRMRepository clienteCRMRepository) {

    	return args -> {
    		clienteCRMRepository.saveAll(
				List.of(
	    			new ClienteCRM("Juan", "Vera", "juan@hotmail.com", "667747474", "Hombre", "Madrid",
	                        "soltero/-a","química", "camarero", "comida", LocalDate.parse("1987-12-29"),
	                        true, 1, null, false, ""),
	    			new ClienteCRM("Juana", "Vez", "juana@hotmail.com","637747474", "Mujer", "Madrid", 
	                        "soltero/-a","filóloga", "traductora", "mascotas",LocalDate.parse("1943-12-06"),
	                        false,  2, null, false, ""),
	    			new ClienteCRM("Sebas", "Toledo", "sebas@hotmail.com", "627337224", "Hombre", "Málaga",
	                         "casado/-a","manager", "director hotel", "idiomas",LocalDate.parse("2000-12-22"),
	                         true,  3, null, false, ""),
	    			new ClienteCRM("Loli", "Paz", "loli@hotmail.com", "611337794",   "Mujer", "Málaga",
	                         "soltero/-a","marketing", "empresaria", "cultura",LocalDate.parse("1991-01-11"),
	                         true,  4, null, false, ""),
	    			new ClienteCRM("Pedro", "Núñez", "pedro@hotmail.com", "688886624",  "Hombre", "Sevilla",
	                         "casado/-a","manager", "director hotel", "idiomas", LocalDate.parse("1970-02-11"),
	                         true,  5, null, false, ""),
	    			new ClienteCRM("Petra", "Willis","petra.willis@hotmail.com", "627337004", "Mujer", "Alicante",
	                         "casado/-a","manager", "director hotel", "idiomas",LocalDate.parse("1958-12-21"), 
	                         false,  6, null, false, ""),
	    			new ClienteCRM("Miguel", "Cervantes", "cervantes@hotmail.com", "627337211", "Hombre", "Bilbao",
	                         "casado/-a","derecho", "bibliotecario", "dibujar",LocalDate.parse("1993-12-16"), 
	                         true,  7, null, false, "")
				)
			);
    	};
    }
}