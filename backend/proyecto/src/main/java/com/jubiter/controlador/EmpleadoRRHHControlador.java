package com.jubiter.controlador;

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
	
	
	@GetMapping("/empleados/{id}")
	public EmpleadoRRHH getEmpleado(@PathVariable int id) {
		return empleadoRRHHService.getEmpleado(id);
	}
	
	
	@PostMapping("/empleados")
	public void addCliente(@RequestBody EmpleadoRRHH empleado) {
		empleadoRRHHService.addEmpleado(empleado);
	}
	
	
	@PutMapping("/empleados/{id}")
	public void updateEmpleado(@PathVariable int id, @RequestBody EmpleadoRRHH empleado) {
		empleadoRRHHService.updateEmpleado(id, empleado);
	}	
	
	
	@DeleteMapping("/empleados/{id}")
	public void deleteEmpleado(@PathVariable int id) {
		empleadoRRHHService.deleteEmpleado(id);
	}
	
	@PatchMapping("empleados/{id}")
	public void patchEmpleado(@PathVariable int id, @RequestBody EmpleadoRRHH empleado) {
		empleadoRRHHService.modifyEmpleado(id, empleado);
	}
		
}


