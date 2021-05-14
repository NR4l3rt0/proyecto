package com.jubiter.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

//import org.springframework.data.repository.CrudRepository;

// El paginador hereda de CrudRepository y permite ordenar también
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.jubiter.modelo.ClienteCRM;

//@RepositoryRestResource(collectionResourceRel = "/clientes-info", path = "/clientes-info")


/**
 * Este repositorio sirve de ejemplo para ver otras opciones en las que se pueden modificar
 * la funcionalidad básica de los métodos. Es decir, sobreescribilos en función de la 
 * necesidad del programa.
 * 
 * @author nr_alberto
 *
 */
@Repository
public interface ClienteCRMRepository extends PagingAndSortingRepository<ClienteCRM, Integer>{


		public ClienteCRM findById(int id);
		public void deleteById(int id);
		
		/**
		 * Hace uso de variables del path
		 * @param nombre
		 * @return una lista de objetos tipo ClienteCRM
		 */
		public List<ClienteCRM> findByNombre(@Param("nombre") String nombre);
		/**
		 * Ayudaría a la hora de paginar y ordenar, al igual que el anterior.
		 * Está la utilidad en backend, pero no se implementa en frontend.
		 * 
		 * @param apellidos
		 * @return lista ordenada de clientes en función del apellido
		 */
		public List<ClienteCRM> findByApellidos(@Param("apellidos") String apellidos);
		
		// From <clase objeto> (no tabla final)
		//@Query("SELECT c FROM ClienteCRM c WHERE c.email = ?1")
		//Optional<ClienteCRM> findClienteByEmail(String email);
	
}
