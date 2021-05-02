package com.jubiter.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

//import org.springframework.data.repository.CrudRepository;

// El paginador hereda de CrudRepository y permite ordenar también
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.jubiter.modelo.ClienteCRM;

//@RepositoryRestResource(collectionResourceRel = "/clientes-info", path = "/clientes-info")
public interface ClienteCRMRepository extends PagingAndSortingRepository<ClienteCRM, Integer>{


		public ClienteCRM findById(int id);
		public void deleteById(int id);
		
		public List<ClienteCRM> findByNombre(@Param("nombre") String nombre);
		public List<ClienteCRM> findByApellidos(@Param("apellidos") String apellidos);
		
		// From <clase objeto> (no tabla final)
		//@Query("SELECT c FROM ClienteCRM c WHERE c.email = ?1")
		//Optional<ClienteCRM> findClienteByEmail(String email);
	
}
