package com.jubiter.controlador;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.jubiter.modelo.EmpleadoRRHH;
import com.jubiter.service.EmpleadoRRHHService;



/**
 * Esta clase implementa los métodos básicos del protocolo HTTP que será accedido desde 
 * el cliente mediante el cliente 'axios'. GET (todos o uno), POST, PUT, PATCH, DELETE.
 * El principal motivo es porque se considera llevar un análisis importante tanto de los
 * empleados como de los clientes.
 * RestController indica que es un controlador y aporta otras características, como concepto
 * semántico.
 * RequestMapping es un end point por el que será enrutado este controlador.
 * CrossOrigin permite el acceso HTTP desde ese punto.
 * @author nr_alberto
 *
 */
@RestController
@RequestMapping("/rrhh")
@CrossOrigin(origins = "http://localhost:3000") 
public class EmpleadoRRHHControlador {


	/**
	 * Objeto inyectado que realizará el enlace del controlador con la implementación del 
	 * servicio
	 */
	@Autowired
	private EmpleadoRRHHService empleadoRRHHService;

	
	
	/**
	 * HTTP GET.
	 * 
	 * @return una lista con todos los objetos empleados.
	 */
	@GetMapping("/empleados")
	public List<EmpleadoRRHH> getEmpleados() {
		return empleadoRRHHService.getAllEmpleados();
	}
	
	/**
	 * HTTP GET.
	 * 
	 * @return un único empleado según el ID tomado del PATH.
	 */
	@GetMapping("/empleados/{empleadoId}")
	public EmpleadoRRHH getEmpleado(@PathVariable int empleadoId) {
		return empleadoRRHHService.getEmpleado(empleadoId);
	}
	
	/**
	 * HTTP POST.
	 * 
	 * Crea un registro en la tabla de los empleados, toma el valor
	 * del objeto que es pasado en el paquete JSON.
	 */
	@PostMapping("/empleados")
	public void addCliente(@RequestBody EmpleadoRRHH empleado) {
		empleadoRRHHService.addEmpleado(empleado);
	}
	
	/**
	 * HTTP PUT.
	 * 
	 * Modifica un determinado elemento en función del identificativo expresado
	 * en el PATH como variable.
	 * El problema es que 'borra' el registro entero para insertar los campos nuevos,
	 * es decir, se puede perder información.
	 */
	@PutMapping("/empleados/{empleadoId}")
	public void updateEmpleado(@PathVariable int empleadoId, @RequestBody EmpleadoRRHH empleado) {
		empleadoRRHHService.updateEmpleado(empleadoId, empleado);
	}	
	
	/**
	 * HTTP DELETE.
	 * 
	 * Elimina un único empleado según el ID tomado del PATH.
	 */
	@DeleteMapping("/empleados/{empleadoId}")
	public void deleteEmpleado(@PathVariable int empleadoId) {
		empleadoRRHHService.deleteEmpleado(empleadoId);
	}
	
	/**
	 * HTTP PATCH.
	 * 
	 * Modifica un único empleado según la variable path, en este caso se produce
	 * una modificación de los campos que se indiquen (siempre y cuando cumplan los
	 * requisitos que se indiquen).
	 * Aporta más flexibilidad.
	 */
	@PatchMapping(value = "/empleados/{empleadoId}",
			  consumes = "application/json-patch+json")
	public void modifyEmpleados(
			    @PathVariable("empleadoId") int empleadoId,
			  	@RequestParam(required = false) String nombre,
			   	@RequestParam(required = false) String email,
			  	@RequestParam(required = false) String tfno,
			   	@RequestParam(required = false) String jornadaTrabajo,
			   	@RequestParam(required = false) String tipoEmpleado,
			   	@RequestParam(required = false) BigDecimal salario
			) {
		
		empleadoRRHHService.modifyEmpleado(empleadoId, nombre, email, tfno,
			   								tipoEmpleado, jornadaTrabajo, salario);	
	}
}


