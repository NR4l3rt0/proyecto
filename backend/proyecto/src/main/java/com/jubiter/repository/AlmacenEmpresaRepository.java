package com.jubiter.repository;

import org.springframework.data.repository.CrudRepository;
import com.jubiter.modelo.AlmacenEmpresa;

/**
 * No necesario en la lógica actual de un único almacén.
 * 
 * @author nr_alberto
 *
 */
public interface AlmacenEmpresaRepository extends CrudRepository<AlmacenEmpresa, Integer>{

}
