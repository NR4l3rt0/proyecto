package com.jubiter.config;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jubiter.modelo.AlmacenProducto;
import com.jubiter.modelo.Producto;
import com.jubiter.repository.AlmacenProductosRepository;



@Configuration
public class AlmacenProductosConfig {

	    @Bean
	    CommandLineRunner commandLineRunnerAlmacenProducto (AlmacenProductosRepository almacenProductosRepository) {
	    	

    return args -> { 
    		
    	List <Producto> productos = List.of(
    	    	new Producto(1, "pechuga pavo", "cocido", BigDecimal.valueOf(10.95),
    	    			"Frial", LocalDate.parse("2021-08-01"), 100),
    	    	new Producto(2, "jamón cocido", "cocido", BigDecimal.valueOf(6.95),
    					"Campo frío", LocalDate.parse("2021-07-10"), 100),	    	
    	    	new Producto(3, "chorizo", "curado", BigDecimal.valueOf(7.95),
    					"revilla", LocalDate.parse("2021-08-01"), 80),
    	    	new Producto(4, "jamón serrano DO", "curado", BigDecimal.valueOf(35.00),
    					"Montesierra", LocalDate.parse("2021-11-01"), 120),
    	    	new Producto(5, "semi curado", "queso", BigDecimal.valueOf(5.75),
    					"Quelac", LocalDate.parse("2021-10-01"), 140),
    	    	new Producto(6, "curado", "queso", BigDecimal.valueOf(14.95),
    					"Quelac", LocalDate.parse("2021-09-01"), 140),
    	    	new Producto(7, "mango", "paté", BigDecimal.valueOf(13.50),
    					"Capdevila", LocalDate.parse("2021-08-01"), 55),
    	    	new Producto(8, "champagne", "paté", BigDecimal.valueOf(15.95),
    					"Capdevila", LocalDate.parse("2021-08-01"), 50)

				);
    	
    		almacenProductosRepository.save(new AlmacenProducto(1, productos, "Jubiter S.L."));
    	};
    }
}
