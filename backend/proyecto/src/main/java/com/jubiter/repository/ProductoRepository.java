package com.jubiter.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jubiter.modelo.ClienteCRM;
import com.jubiter.modelo.Producto;


/**
 * Implementa la funcionalidad básica para realizar un CRUD desde la aplicación
 * con la base de datos.
 * Se ponen los métodos, peri la mayoría de las veces no es necesario pues vienen
 * por defecto.
 * 
 * @author nr_alberto
 *
 */
@Repository
public interface ProductoRepository extends CrudRepository<Producto, Integer>{

	/**
	 * Se usa el Optional, que indica una clase que maneja la posibilidad de la "nulidad".
	 * Desde java 8, se relaciona con el paradigma funcional.
	 */
	public Optional<Producto> findById(Integer productoId);
	public Producto findById(int productoId);
	public void deleteById(Integer productoId);
}
