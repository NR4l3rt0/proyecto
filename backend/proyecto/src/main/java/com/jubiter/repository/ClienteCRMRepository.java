package com.jubiter.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

//import org.springframework.data.repository.CrudRepository;

// El paginador hereda de CrudRepository y permite ordenar también
import org.springframework.data.repository.PagingAndSortingRepository;

import com.jubiter.modelo.ClienteCRM;


public interface ClienteCRMRepository extends PagingAndSortingRepository<ClienteCRM, Integer>{


		public ClienteCRM findById(int id);
		public void deleteById(int id);
		
		// From <clase objeto> (no tabla final)
		//@Query("SELECT c FROM ClienteCRM c WHERE c.email = ?1")
		//Optional<ClienteCRM> findClienteByEmail(String email);
	
}
