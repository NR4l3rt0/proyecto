package com.jubiter.config;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import com.jubiter.modelo.AlmacenEmpresa;
import com.jubiter.repository.AlmacenEmpresaRepository;


/**
 * Componente que sirva para cargar los datos del almacén. En este caso sería una
 * empresa con 3 almacenes.
 * 
 * @author nr_alberto
 *
 */
@Configuration
public class AlmacenEmpresaConfig {
	
	/**
	 * Las anotaciones @DependsOn indica que se ejecutará tras lo que se referencia, 
	 * y @Bean usado en inyección son fundamentales para el correcto funcionamiento
	 * de la clase.
	 * Este runner inicializará la tabla correspondiente que es referenciada en PostgreSQL.
	 *
	 * 
	 * @param almacenEmpresaRepository
	 * @return la tabla inicializada con estos registros
	 */
	@DependsOn({"EmpleadoRRHHConfig","ClienteCRMConfig"})
    @Bean("AlmacenEmpresaConfig")
    CommandLineRunner commandLineRunnerAlmacenEmpresa (AlmacenEmpresaRepository almacenEmpresaRepository) {
    	

		return args -> { 
		
			almacenEmpresaRepository.save(new AlmacenEmpresa("Jubiter S.L."));
			almacenEmpresaRepository.save(new AlmacenEmpresa("Jubiter S.L."));
			almacenEmpresaRepository.save(new AlmacenEmpresa("Jubiter S.L."));
	
		};
	}

}
