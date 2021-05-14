package com.jubiter.config;
 
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import com.jubiter.modelo.AlmacenEmpresa;
import com.jubiter.modelo.Producto;
import com.jubiter.repository.AlmacenEmpresaRepository;
import com.jubiter.repository.ProductoRepository;

/**
 * Inicialización de la tabla producto a traves de la clase en Java correspondiente
 * 
 * @author nr_alberto
 *
 */
@Configuration
public class ProductoConfig {

   


    @Bean("ProductoConfig")
    CommandLineRunner commandLineRunnerProducto(ProductoRepository productoRepository) {

    	return args -> {
   	
    		productoRepository.saveAll(
				List.of(				
				    	new Producto("pechuga pavo", "cocido",
				    			"Frial", LocalDate.parse("2021-08-01"), 100, BigDecimal.valueOf(10.95)),
				    	new Producto("jamón cocido", "cocido",
								"Campofrío", LocalDate.parse("2021-07-10"), 100, BigDecimal.valueOf(6.95)),	    	
				    	new Producto("chorizo", "curado",
								"Revilla", LocalDate.parse("2021-08-01"), 80, BigDecimal.valueOf(7.95)),
				    	new Producto("jamón serrano DO", "curado",
								"Montesierra", LocalDate.parse("2021-11-01"), 120, BigDecimal.valueOf(35.00)),
				    	new Producto( "queso semi", "semi curado",
								"Quelac", LocalDate.parse("2021-10-01"), 140, BigDecimal.valueOf(5.75)),
				    	new Producto("queso","curado", 
								"Quelac", LocalDate.parse("2021-09-01"), 140, BigDecimal.valueOf(14.95)),
				    	new Producto("mango", "paté",
								"Capdevila", LocalDate.parse("2021-08-01"), 55, BigDecimal.valueOf(13.50)),
				    	new Producto("champagne", "paté",
								"Capdevila", LocalDate.parse("2021-08-01"), 50, BigDecimal.valueOf(15.95))
						
						
						)
    		);
        };
	}
}

