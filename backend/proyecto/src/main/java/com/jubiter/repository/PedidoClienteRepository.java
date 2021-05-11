package com.jubiter.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jubiter.modelo.PedidoCliente;
import java.util.List;
import java.util.UUID;
import java.util.Optional;
import com.jubiter.modelo.ClienteCRM;

@Repository
public interface PedidoClienteRepository 
						extends CrudRepository<PedidoCliente, Integer> {
/*
	// JPQL
	//@Query("SELECT pc FROM PedidoCliente pc WHERE pc.clienteCRM = ?1")
	List<PedidoCliente> findAllPedidoClienteByClienteCRM(ClienteCRM clienteCRM);

	//@Query("SELECT pc FROM PedidoCliente pc WHERE pc.idPedidoCliente = ?1")
	List<PedidoCliente> findPedidoClienteById(UUID pedidoClienteId);
	
	//@Query("DELETE FROM PedidoCliente pc WHERE pc.idPedidoCliente = ?1")
	void deleteById(UUID idPedidoCliente);
	
	*/
}
