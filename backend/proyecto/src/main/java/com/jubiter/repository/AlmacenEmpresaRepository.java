package com.jubiter.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jubiter.modelo.AlmacenEmpresa;

@Repository
public interface AlmacenEmpresaRepository 
								extends CrudRepository<AlmacenEmpresa, Integer>{

}
