package com.jubiter.controlador;

//import com.github.fge.jsonpatch.JsonPatch;
import com.jubiter.modelo.ClienteCRM;
import com.jubiter.service.ClienteCRMService;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/crm")
public class ClienteCRMControlador {

	
	@Autowired
	private ClienteCRMService clienteCRMService;

	
	
	
	@GetMapping("/clientes")
	public List<ClienteCRM>getClientes() {
		return clienteCRMService.getAllClientes();
	}
	
	
	@GetMapping("/clientes/{clienteId}")
	public ClienteCRM getCliente(@PathVariable int clienteId) {
		return clienteCRMService.getCliente(clienteId);
	}
	
	
	// Aunque POST y PUT llamen al mismo método en servicio
	// se pone separado por claridad en la llamada debido al path
	
	@PostMapping("/clientes")
	public void addCliente(@RequestBody ClienteCRM cliente) {
		clienteCRMService.addCliente(cliente);
	}
	
	
	@PutMapping("/clientes/{clienteId}")
	public void updateCliente(@PathVariable int clienteId, @RequestBody ClienteCRM cliente) {
		clienteCRMService.updateCliente(clienteId, cliente);
		
	}	
	
	
	@DeleteMapping("/clientes/{clienteId}")
	public void deleteCliente(@PathVariable int clienteId) {
		clienteCRMService.deleteCliente(clienteId);
	}
	
	/*
	@PatchMapping(value = "/clientes/{clienteId}",
				  consumes = "application/json-patch+json")
	public void modifyCliente(@PathVariable int clienteId, @RequestBody JsonPatch patch) {
		clienteCRMService.modifyCliente(clienteId, patch);
	}*/
	
	@PatchMapping(value = "/clientes/{clienteId}",
			  consumes = "application/json-patch+json")
	public void modifyCliente(
			    @PathVariable("clienteId") int clienteId,
			  	@RequestParam(required = false) String nombre,
			   	@RequestParam(required = false) String email,
			  	@RequestParam(required = false) String tfno,
			   	@RequestParam(required = false) String localidad,
			   	@RequestParam(required = false) String fechaNacimiento
			) 
	{
			   		clienteCRMService.modifyCliente(clienteId, nombre, email,
			   										tfno, localidad, fechaNacimiento);
	
	
	
	}		
}
