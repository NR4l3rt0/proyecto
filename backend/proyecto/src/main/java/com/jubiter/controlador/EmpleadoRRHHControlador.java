package com.jubiter.controlador;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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




@RestController
@RequestMapping("/rrhh")
public class EmpleadoRRHHControlador {


	
	@Autowired
	private EmpleadoRRHHService empleadoRRHHService;

	
	
	
	@GetMapping("/empleados")
	public List<EmpleadoRRHH> getEmpleados() {
		return empleadoRRHHService.getAllEmpleados();
	}
	
	
	@GetMapping("/empleados/{empleadoId}")
	public EmpleadoRRHH getEmpleado(@PathVariable int empleadoId) {
		return empleadoRRHHService.getEmpleado(empleadoId);
	}
	
	
	@PostMapping("/empleados")
	public void addCliente(@RequestBody EmpleadoRRHH empleado) {
		empleadoRRHHService.addEmpleado(empleado);
	}
	
	
	@PutMapping("/empleados/{empleadoId}")
	public void updateEmpleado(@PathVariable int empleadoId, @RequestBody EmpleadoRRHH empleado) {
		empleadoRRHHService.updateEmpleado(empleadoId, empleado);
	}	
	
	
	@DeleteMapping("/empleados/{empleadoId}")
	public void deleteEmpleado(@PathVariable int empleadoId) {
		empleadoRRHHService.deleteEmpleado(empleadoId);
	}
	

	@PatchMapping(value = "/empleados/{empleadoId}",
			  consumes = "application/json-patch+json")
	public void modifyEmpleados(
			    @PathVariable("empleadoId") int empleadoId,
			  	@RequestParam(required = false) String nombre,
			   	@RequestParam(required = false) String email,
			  	@RequestParam(required = false) String tfno,
			   	@RequestParam(required = false) String jornadaTrabajo,
			   	@RequestParam(required = false) BigDecimal salario
			) {
		
		empleadoRRHHService.modifyEmpleado(empleadoId, nombre, email,
			   										tfno, jornadaTrabajo, salario);	
	}
}


