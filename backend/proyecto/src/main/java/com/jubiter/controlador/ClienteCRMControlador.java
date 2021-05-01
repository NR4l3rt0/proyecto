package com.jubiter.controlador;

import com.jubiter.modelo.ClienteCRM;
import com.jubiter.service.ClienteCRMService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	
	@GetMapping("/clientes/{id}")
	public ClienteCRM getCliente(@PathVariable int id) {
		return clienteCRMService.getCliente(id);
	}
	
	
	// Aunque POST y PUT llamen al mismo método en servicio
	// se pone separado por claridad en la llamada debido al path
	
	@PostMapping("/clientes")
	public void addCliente(@RequestBody ClienteCRM cliente) {
		clienteCRMService.addCliente(cliente);
	}
	
	
	@PutMapping("/clientes/{id}")
	public void updateCliente(@PathVariable int id, @RequestBody ClienteCRM cliente) {
		clienteCRMService.updateCliente(id, cliente);
	}	
	
	
	@DeleteMapping("/clientes/{id}")
	public void deleteCliente(@PathVariable int id) {
		clienteCRMService.deleteCliente(id);
	}
		
}
