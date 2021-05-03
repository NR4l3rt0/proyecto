package com.jubiter.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.jubiter.modelo.PedidoCliente;

public interface PedidoClienteRepository 
						extends PagingAndSortingRepository<PedidoCliente, Integer> {

}
