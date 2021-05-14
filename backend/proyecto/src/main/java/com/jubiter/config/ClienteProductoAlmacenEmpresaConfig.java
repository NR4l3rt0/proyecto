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

/*
 * Se plantea que forme parte de la lógica. Se debería llevar a cabo un estudio del componente
 * con Hibernate y la base de datos.
 * 
 * Esta clase queda definida por un enlace ternario.
 */
public class ClienteProductoAlmacenEmpresaConfig {


    @Bean("ClienteCRMConfig")
    CommandLineRunner commandLineRunnerClienteCRM (ClienteProductoAlmacenEmpresaRepository clienteProductoAlmacenEmpresa) {

    	
    	return args -> {
    		clienteProductoAlmacenEmpresa.saveAll(
				List.of()
			);
    	};
    }
}
