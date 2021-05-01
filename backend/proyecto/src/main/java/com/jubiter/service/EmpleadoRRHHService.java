package com.jubiter.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;


import com.jubiter.modelo.EmpleadoRRHH;
import com.jubiter.repository.EmpleadoRRHHRepository;


@Service
public class EmpleadoRRHHService {
		
		
		@Autowired
		private EmpleadoRRHHRepository empleadoRRHHRepository;  
		
		
		
		public List<EmpleadoRRHH> getAllEmpleados(){
			List<EmpleadoRRHH> empleados = new ArrayList<>();
				empleadoRRHHRepository.findAll()
									  .forEach(empleados::add);    

			return empleados;
					
		}

		
		public EmpleadoRRHH getEmpleado(int id){
			return empleadoRRHHRepository.findById(id);	
		}
		

		public void addEmpleado(EmpleadoRRHH empleado) {
			empleadoRRHHRepository.save(empleado);
			
		}


		public void updateEmpleado(int id, EmpleadoRRHH empleado) {
			empleadoRRHHRepository.save(empleado);
					
		}

		
		public void deleteEmpleado(int id) {
			empleadoRRHHRepository.deleteById(id);		
			
		}


/*
		public void modifyEmpleado(int id, EmpleadoRRHH empleado) {
			EmpleadoRRHH e = empleadoRRHHRepository.findById(id);
			
			empleado.getValues()
			
			
		}*/
		
}
