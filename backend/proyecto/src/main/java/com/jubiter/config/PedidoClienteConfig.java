package com.jubiter.config;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jubiter.modelo.EmpleadoRRHH;
import com.jubiter.modelo.PedidoCliente;
import com.jubiter.modelo.Producto;
import com.jubiter.repository.EmpleadoRRHHRepository;
import com.jubiter.repository.PedidoClienteRepository;

@Configuration
public class PedidoClienteConfig {

	
    @Bean
    CommandLineRunner commandLineRunnerPedidoCliente (PedidoClienteRepository pedidoClienteRepository) {

    	return args -> {
    		

    		pedidoClienteRepository.saveAll(
				List.of(
	    			new PedidoCliente(UUID.randomUUID(),
	    					Arrays.asList(new Producto(2, 5, 10.95), new Producto(5, 10, 6.95)),
	    							"pedido", "online", "online", 0.0, LocalDate.now().toString(), 1, 2),
	    			new PedidoCliente(UUID.randomUUID(),
	    					List.of(new Producto(1, 5, 10.95), new Producto(4, 10, 6.95)),
	    							"pedido", "online", "online", 0.0, LocalDate.now().toString(), 4, 1),
	    			new PedidoCliente(UUID.randomUUID(),
	    					List.of(new Producto(3, 5, 10.95), new Producto(4, 10, 6.95)),
	    							"pedido", "online", "online", 0.0, LocalDate.now().toString(), 6, 3),
	    			new PedidoCliente(UUID.randomUUID(),
	    					List.of(new Producto(2, 5, 10.95), new Producto(5, 10, 6.95)),
	    							"pedido", "online", "online", 0.0, LocalDate.now().toString(), 3, 4)

				)
			);
    	};
    }
	
}
