package com.jubiter.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.jubiter.modelo.EmpleadoRRHH;


@Repository
public interface EmpleadoRRHHRepository extends PagingAndSortingRepository<EmpleadoRRHH, Integer>{


	public EmpleadoRRHH findById(int id);
	public void deleteById(int id);

}