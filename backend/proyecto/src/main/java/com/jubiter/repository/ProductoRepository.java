package com.jubiter.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jubiter.modelo.ClienteCRM;
import com.jubiter.modelo.Producto;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Integer>{

	public Producto findById(int productoId);
	public void deleteById(int productoId);
}
