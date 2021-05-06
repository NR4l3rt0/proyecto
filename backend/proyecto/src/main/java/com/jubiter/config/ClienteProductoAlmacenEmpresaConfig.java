package com.jubiter.config;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import com.jubiter.modelo.AlmacenEmpresa;
import com.jubiter.modelo.ClienteCRM;
import com.jubiter.modelo.ClienteProductoAlmacenEmpresa;
import com.jubiter.modelo.ClienteProductoAlmacenEmpresaCK;
import com.jubiter.modelo.PedidoCliente;
import com.jubiter.modelo.Producto;
import com.jubiter.repository.ClienteProductoAlmacenEmpresaRepository;

public class ClienteProductoAlmacenEmpresaConfig {


    @Bean("ClienteCRMConfig")
    CommandLineRunner commandLineRunnerClienteCRM (ClienteProductoAlmacenEmpresaRepository clienteProductoAlmacenEmpresa) {

    	
    	return args -> {
    		clienteProductoAlmacenEmpresa.saveAll(
				List.of(/*
						new ClienteProductoAlmacenEmpresa(new ClienteProductoAlmacenEmpresa(1, 2,
								 							 UUID.fromString("aaa99b0c-7b54-4327-b81e-2a661ffe9dbe")),
						new ClienteProductoAlmacenEmpresa(new ClienteProductoAlmacenEmpresaC 1, 1
										UUID.fromString("bbb99b0c-7b54-4327-b81e-2a661ffe9dbe")),
						new ClienteProductoAlmacenEmpresa(new ClienteProductoAlmacenEmpresa(1, 4
															UUID.fromString("vvv99b0c-7b54-4327-b81e-2a661ffe9dbe")), 
						new ClienteProductoAlmacenEmpresa(new ClienteProductoAlmacenEmpresa( 1, 2
															UUID.fromString("vvv99b0c-7b54-4327-b81e-2a661ffe9dbe")*/
						/*
						
						new ClienteProductoAlmacenEmpresa(
								new AlmacenEmpresa("Jubiter S.L."), 
								new Producto("pechuga pavo", "cocido",
						    			"Frial", LocalDate.parse("2021-08-01"), 10, BigDecimal.valueOf(10.95)),
								new PedidoCliente(UUID.fromString("aaa99b0c-7b54-4327-b81e-2a661ffe9dbe"), "online", "normal", "online",BigDecimal.valueOf(0.0),
										LocalDate.now())


						)*/
					)
			);
    	};
    }
}
