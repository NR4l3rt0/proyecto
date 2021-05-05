package com.jubiter.config;

import java.util.List;
import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import com.jubiter.modelo.ClienteProductoAlmacenEmpresa;
import com.jubiter.modelo.ClienteProductoAlmacenEmpresaCK;
import com.jubiter.repository.ClienteProductoAlmacenEmpresaRepository;

public class ClienteProductoAlmacenEmpresaConfig {


    @Bean("ClienteCRMConfig")
    CommandLineRunner commandLineRunnerClienteCRM (ClienteProductoAlmacenEmpresaRepository clienteProductoAlmacenEmpresa) {

    	
    	return args -> {
    		clienteProductoAlmacenEmpresa.saveAll(
				List.of(/*
						new ClienteProductoAlmacenEmpresa(new ClienteProductoAlmacenEmpresaCK(1, 2,
								 							 UUID.fromString("aaa99b0c-7b54-4327-b81e-2a661ffe9dbe")),
						new ClienteProductoAlmacenEmpresa(new ClienteProductoAlmacenEmpresaCK( 1, 1
										UUID.fromString("bbb99b0c-7b54-4327-b81e-2a661ffe9dbe")),
						new ClienteProductoAlmacenEmpresa(new ClienteProductoAlmacenEmpresaCK(1, 4
															UUID.fromString("vvv99b0c-7b54-4327-b81e-2a661ffe9dbe")), 
						new ClienteProductoAlmacenEmpresa(new ClienteProductoAlmacenEmpresaCK( 1, 2
															UUID.fromString("vvv99b0c-7b54-4327-b81e-2a661ffe9dbe")
						*/
						)
			);
    	};
    }
}
