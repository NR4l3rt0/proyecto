package com.jubiter.repository;

import org.springframework.data.repository.CrudRepository;

import com.jubiter.modelo.ClienteProductoAlmacenEmpresa;
import com.jubiter.modelo.ClienteProductoAlmacenEmpresaCK;

public interface ClienteProductoAlmacenEmpresaRepository 
								extends CrudRepository<ClienteProductoAlmacenEmpresa, 
														ClienteProductoAlmacenEmpresaCK>{

}
