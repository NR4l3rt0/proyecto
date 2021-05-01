package com.jubiter.repository;

//import org.springframework.data.repository.CrudRepository;

// El paginador hereda de CrudRepository y permite ordenar también
import org.springframework.data.repository.PagingAndSortingRepository;

import com.jubiter.modelo.ClienteCRM;


public interface ClienteCRMRepository extends PagingAndSortingRepository<ClienteCRM, Integer>{


		public ClienteCRM findById(int id);
		public void deleteById(int id);
	
}
