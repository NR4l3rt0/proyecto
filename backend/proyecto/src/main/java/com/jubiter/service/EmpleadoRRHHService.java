package com.jubiter.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jubiter.Excepcion.IdNoEncontradoException;

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

		
		public EmpleadoRRHH getEmpleado(int empleadoId){
			
			boolean existe = empleadoRRHHRepository.existsById(empleadoId);
			
			if(!existe) {
				
				throw new IllegalStateException(
						"No existe un cliente con ID: " + empleadoId);
			}
	
			
			return empleadoRRHHRepository.findById(empleadoId);	
		}
		

		
		public void addEmpleado(EmpleadoRRHH empleado) {
			
			if(empleado.getDni().isBlank()) {
				throw new IllegalStateException(
						"Es necesario que el DNI esté relleno y sea válido");
			} 
			
			empleadoRRHHRepository.save(empleado);
			
			
		}


		public void updateEmpleado(int empleadoId, EmpleadoRRHH empleado) {
			
			if(empleado.getDni().isBlank()) {
				throw new IllegalStateException(
						"Es necesario que el DNI esté relleno y sea válido");
			} 
				

			empleadoRRHHRepository.save(empleado);
			
		}

		
		public void deleteEmpleado(int empleadoId) {
			
			boolean existe = empleadoRRHHRepository.existsById(empleadoId);
			
			if(!existe) {
				throw new IllegalStateException(
						"No existe un cliente con ID: " + empleadoId);
			}
			empleadoRRHHRepository.deleteById(empleadoId);		
			
		}


		public void modifyEmpleado(int empleadoId, String nombre, String email, String tfno,
									 String tipoEmpleado, String jornadaTrabajo, BigDecimal salario) {
			
			EmpleadoRRHH empleado = empleadoRRHHRepository.findById(empleadoId);
			
			if(empleado == null) {
				throw new IdNoEncontradoException(
							"No se ha encontrado ninguna coincidencia con ese ID.");
			}
			

			if (nombre != null && !nombre.equals(empleado.getNombre())){
				empleado.setNombre(nombre);
			}
			
			if (email != null && !email.equals(empleado.getEmail())){
				empleado.setEmail(email);
			}
			
			if (tfno != null && !tfno.equals(empleado.getTfno())){
				empleado.setTfno(tfno);
			}
			
			if (salario != null && salario != empleado.getSalario()){
				empleado.setSalario(salario);
			}
			
			if (tipoEmpleado != null && !tipoEmpleado.equals(empleado.getTipoEmpleado())){
				empleado.setTipoEmpleado(tipoEmpleado);
			}
			

			if (jornadaTrabajo != null && !jornadaTrabajo.equals(empleado.getJornadaTrabajo())){
				empleado.setJornadaTrabajo(jornadaTrabajo);
			}
			
			empleadoRRHHRepository.save(empleado);
		}


/*
		public void modifyEmpleado(int id, EmpleadoRRHH empleado) {
			EmpleadoRRHH e = empleadoRRHHRepository.findById(id);
			
			empleado.getValues()
			
			
		}*/
		
}
