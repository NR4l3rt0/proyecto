package com.jubiter.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.jubiter.modelo.EmpleadoRRHH;



public interface EmpleadoRRHHRepository extends PagingAndSortingRepository<EmpleadoRRHH, Integer>{


	public EmpleadoRRHH findById(int id);
	public void deleteById(int id);

}