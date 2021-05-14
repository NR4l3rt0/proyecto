package com.jubiter.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jubiter.exception.IdNoEncontradoException;
import com.jubiter.modelo.EmpleadoRRHH;
import com.jubiter.repository.EmpleadoRRHHRepository;

/**
 * Se encarga de implementar el servicio entre su controlador y su repositorio.
 * Es muy similar a la lógica expuesta en el servicio de 
 * {@link com.jubiter.service.ProductoService}.
 * 
 * Sí cabe mencionar que propone un PATCH mucho más extenso para poder trabajar 
 * con diferentes departamentos dentro de la empresa.
 * 
 * @author nr_alberto
 *
 */
@Service
public class EmpleadoRRHHService {
		
		/**
		 * Inyección del bean que hace uso del repositorio
		 */
		@Autowired
		private EmpleadoRRHHRepository empleadoRRHHRepository;  
		
		
		/**
		 * HTTP GET
		 * @return lista de empleados
		 */
		public List<EmpleadoRRHH> getAllEmpleados(){
			List<EmpleadoRRHH> empleados = new ArrayList<>();
				empleadoRRHHRepository.findAll()
									  .forEach(empleados::add);    

			return empleados;
					
		}

		/**
		 * HTTP GET
		 * @param empleadoId
		 * @return un único empleado indicado por valor clave
		 */
		public EmpleadoRRHH getEmpleado(int empleadoId){
			
			boolean existe = empleadoRRHHRepository.existsById(empleadoId);
			
			if(!existe) {
				
				throw new IllegalStateException(
						"No existe un cliente con ID: " + empleadoId);
			}
	
			
			return empleadoRRHHRepository.findById(empleadoId);	
		}
		

		/**
		 * HTTP POST
		 * @param empleado, objeto JSON 
		 */
		public void addEmpleado(EmpleadoRRHH empleado) {
			
			if(empleado.getDni().isBlank()) {
				throw new IllegalStateException(
						"Es necesario que el DNI esté relleno y sea válido");
			} 
			
			empleadoRRHHRepository.save(empleado);
			
			
		}


		/**
		 * HTTP PUT 
		 * 
		 * @param empleadoId, de la variable PATH
		 * @param empleado, del body
		 */
		public void updateEmpleado(int empleadoId, EmpleadoRRHH empleado) {
			
			if(empleado.getDni().isBlank()) {
				throw new IllegalStateException(
						"Es necesario que el DNI esté relleno y sea válido");
			} 
				

			empleadoRRHHRepository.save(empleado);
			
		}

		
		/**
		 * HTTP DELETE
		 * 
		 * @param empleadoId, del PATH
		 */
		public void deleteEmpleado(int empleadoId) {
			
			boolean existe = empleadoRRHHRepository.existsById(empleadoId);
			
			if(!existe) {
				throw new IllegalStateException(
						"No existe un cliente con ID: " + empleadoId);
			}
			empleadoRRHHRepository.deleteById(empleadoId);		
			
		}

		/**
		 * HTTP PATCH
		 * 
		 * Permite modificar nombre, email, tfno, tipo de empleado, jornada y salario
		 * 
		 * @param empleadoId
		 * @param nombre
		 * @param email
		 * @param tfno
		 * @param tipoEmpleado
		 * @param jornadaTrabajo
		 * @param salario
		 */
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


		
}
