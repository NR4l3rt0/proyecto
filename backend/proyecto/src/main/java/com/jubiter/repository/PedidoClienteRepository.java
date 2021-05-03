package com.jubiter.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.jubiter.modelo.PedidoCliente;

@Repository
public interface PedidoClienteRepository 
						extends PagingAndSortingRepository<PedidoCliente, Integer> {

}
