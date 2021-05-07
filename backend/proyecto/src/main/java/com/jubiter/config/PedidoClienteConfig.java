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
import org.springframework.context.annotation.DependsOn;

import com.jubiter.modelo.ClienteCRM;
import com.jubiter.modelo.PedidoCliente;
import com.jubiter.repository.PedidoClienteRepository;

@Configuration
public class PedidoClienteConfig {

  
	//@DependsOn({"ClienteProductoAlmacenEmpresa"})  
    @Bean("PedidoClienteConfig")
    CommandLineRunner commandLineRunnerPedidoCliente (PedidoClienteRepository pedidoClienteRepository) {

        return args -> { 
/*
	
        	PedidoCliente p1 = new PedidoCliente(, BigDecimal.valueOf(0.0),
							"pedido", LocalDate.now(), LocalDate.parse("1999-11-11"), "online", "online", 1, 1, 2);
        	PedidoCliente p2 = new PedidoCliente( BigDecimal.valueOf(20.0),
							"pedido", LocalDate.now(), LocalDate.parse("1999-11-11"),"online", "online", 1,  2, 1);
			PedidoCliente p3 = new PedidoCliente( BigDecimal.valueOf(80.0),
							"pedido", LocalDate.now(), LocalDate.parse("1999-11-11"),"online", "online", 1, 2, 1);
        	PedidoCliente p4 = new PedidoCliente( BigDecimal.valueOf(110.0),
							"pedido", LocalDate.now(), LocalDate.parse("1999-11-11"),"online", "online", 1, 2, 2);
     */ 					

        	PedidoCliente p1 = new PedidoCliente(UUID.fromString("aaa99b0c-7b54-4327-b81e-2a661ffe9dbe"), "online", "normal", "online",BigDecimal.valueOf(0.0),
							LocalDate.now(), new ClienteCRM(2));
        	PedidoCliente p2 = new PedidoCliente(UUID.fromString("bbb99b0c-7b54-4327-b81e-2a661ffe9dbe"), "online", "urgente", "online",BigDecimal.valueOf(20.0),
							LocalDate.now(), new ClienteCRM(4));
			PedidoCliente p3 = new PedidoCliente(UUID.fromString("ccc99b0c-7b54-4327-b81e-2a661ffe9dbe"), "online", "normal", "online",BigDecimal.valueOf(80.0),
							LocalDate.now(), new ClienteCRM(2));
        	PedidoCliente p4 = new PedidoCliente(UUID.fromString("ddd99b0c-7b54-4327-b81e-2a661ffe9dbe"),"online", "normal", "online",BigDecimal.valueOf(110.0),
        					LocalDate.now(), new ClienteCRM(3));
        	
        	pedidoClienteRepository.saveAll(List.of(p1, p2, p3, p4));
	
    	};
    }   
}
