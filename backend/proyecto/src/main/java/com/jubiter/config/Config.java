package com.jubiter.config;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import com.jubiter.modelo.AlmacenEmpresa;
import com.jubiter.modelo.PedidoCliente;
import com.jubiter.modelo.Producto;
import com.jubiter.repository.AlmacenEmpresaRepository;
import com.jubiter.repository.PedidoClienteRepository;
import com.jubiter.repository.ProductoRepository;


@Configuration
public class Config {

	
    @Bean("almacen")
    CommandLineRunner commandLineRunnerAlmacenEmpresa (AlmacenEmpresaRepository almacenEmpresaRepository) {
    	

		return args -> { 
		
			almacenEmpresaRepository.save(new AlmacenEmpresa(1, "Jubiter S.L."));
	
		};
	}
	
	@DependsOn({"almacen"})  
    @Bean("pedidos")
    CommandLineRunner commandLineRunnerPedidoCliente (PedidoClienteRepository pedidoClienteRepository) {

        return args -> { 

	
        	PedidoCliente p1 = new PedidoCliente(UUID.fromString("aaa99b0c-7b54-4327-b81e-2a661ffe9dbe"), BigDecimal.valueOf(0.0),
							"pedido", LocalDate.now(), LocalDate.parse("1999-11-11"), "online", "online", 1, 1, 2);
        	PedidoCliente p2 = new PedidoCliente(UUID.fromString("bbb99b0c-7b54-4327-b81e-2a661ffe9dbe"), BigDecimal.valueOf(20.0),
							"pedido", LocalDate.now(), LocalDate.parse("1999-11-11"),"online", "online", 1,  2, 1);
			PedidoCliente p3 = new PedidoCliente(UUID.fromString("ccc99b0c-7b54-4327-b81e-2a661ffe9dbe"), BigDecimal.valueOf(80.0),
							"pedido", LocalDate.now(), LocalDate.parse("1999-11-11"),"online", "online", 1, 2, 1);
        	PedidoCliente p4 = new PedidoCliente(UUID.fromString("ddd99b0c-7b54-4327-b81e-2a661ffe9dbe"), BigDecimal.valueOf(110.0),
							"pedido", LocalDate.now(), LocalDate.parse("1999-11-11"),"online", "online", 1, 2, 2);
        							
        	
        	pedidoClienteRepository.saveAll(List.of(p1, p2, p3, p4));
	
    	};
    }
    
    

	@DependsOn({"almacen", "pedidos"}) 
    @Bean("productos")
    CommandLineRunner commandLineRunnerProducto(ProductoRepository productoRepository) {

    	return args -> {
   	
    		productoRepository.saveAll(
				List.of(
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
				    	)
			);

        };
    }
    
}
