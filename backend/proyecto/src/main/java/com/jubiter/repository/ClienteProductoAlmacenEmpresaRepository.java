package com.jubiter.repository;

import org.springframework.data.repository.CrudRepository;

import com.jubiter.modelo.ClienteProductoAlmacenEmpresa;
import com.jubiter.modelo.ClienteProductoAlmacenEmpresaCK;

/**
 * Al no haberse implementado no se usa. 
 * Es interesante saber que Spring a partir de la interfaz que se herede
 * establece un mapeo entre propiedades y funcionalidades típicas que pueden
 * ser usadas sin definirse explícitamente.
 * 
 * @author nr_alberto
 *
 */
public interface ClienteProductoAlmacenEmpresaRepository 
								extends CrudRepository<ClienteProductoAlmacenEmpresa, 
														ClienteProductoAlmacenEmpresaCK>{

}
