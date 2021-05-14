package com.jubiter.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.jubiter.exception.IdNoEncontradoException;
import com.jubiter.modelo.ClienteCRM;
import com.jubiter.repository.ClienteCRMRepository;

/**
 * Se encarga de implementar el servicio entre controlador -repositorio.
 * Es muy similar a la lógica expuesta 
 * {@link com.jubiter.service.ProductoService} y 
 * {@link com.jubiter.service.EmpleadoRRHHService}.
 * 
 * Se propone un PATCH con un foco distinto para analizar hábitos o mercado meta.
 * 
 * @author nr_alberto
 *
 */
@Service
public class ClienteCRMService {
	
	
	@Autowired
	private ClienteCRMRepository clienteCRMRepository;  // Inyección
	
	/**
	 * HTTP GET
	 * @return lista de clientes
	 */
	public List<ClienteCRM>getAllClientes(){
		List<ClienteCRM> clientes = new ArrayList<>();
		clienteCRMRepository.findAll()
						 	.forEach(clientes::add);     // llamada por referencia al método del tipo

		return clientes;
				
	}

	/**
	 * HTTP GET
	 * @param clienteId
	 * @return un único cliente indicado por ID
	 */
	public ClienteCRM getCliente(int clienteId){	
		
		boolean existe = clienteCRMRepository.existsById(clienteId);
		
		if(!existe) {
			
			throw new IllegalStateException(
					"No existe un cliente con ID: " + clienteId);
		}
		
		return clienteCRMRepository.findById(clienteId);	// método sugerido en ClienteCRMRepository

	}
	

	/**
	 * HTTP POST
	 * @param cliente
	 */
	public void addCliente(ClienteCRM cliente) {
		
		// Se plantea un registro en empresa con tfno o email
		if(cliente.getEmail().isBlank() && cliente.getTfno().isBlank()) {
			throw new IllegalStateException(
					"Es necesario aportar un email o un teléfono como mínimo");
		} else {
			clienteCRMRepository.save(cliente);
		}
		
	}

	
	/**
	 * HTTP PUT 
	 * 
	 * @param clienteId, de variable PATH
	 * @param cliente, request del body
	 */
	public void updateCliente(int clienteId, ClienteCRM cliente) {
		
		if(cliente.getEmail().isBlank() && cliente.getTfno().isBlank()) {
			throw new IllegalStateException(
					"Es necesario aportar un email o un teléfono como mínimo");
		} else {
		
			clienteCRMRepository.save(cliente);
		}
				
	}

	
	/**
	 * HTTP DELETE
	 * 
	 * @param clienteId, del PATH
	 */
	public void deleteCliente(int clienteId) {
		
		boolean existe = clienteCRMRepository.existsById(clienteId);
		
		if(!existe) {
			throw new IllegalStateException(
					"No existe un cliente con ID: " + clienteId);
		}
		
		clienteCRMRepository.deleteById(clienteId);		// también sugerido en ClienteCRMRepository
		
	}


	/**
	 * HTTP PATCH
	 * 
	 * Permite modificar nombre, email, tfno, localidad y fechaNacimiento
	 * 
	 * @param empleadoId
	 * @param nombre
	 * @param email
	 * @param tfno
	 * @param localidad
	 * @param fechaNacimiento
	 */
	public void modifyCliente(int clienteId, String nombre, String email, String tfno, 
			String localidad,
			String fechaNacimiento) {
			
		ClienteCRM cliente = clienteCRMRepository.findById(clienteId);
		
		if(cliente == null) {
			throw new IdNoEncontradoException(
						"No se ha encontrado ninguna coincidencia con ese ID.");
		}
		

		if (nombre != null && !nombre.equals(cliente.getNombre())){
			cliente.setNombre(nombre);
		}
		
		if (email != null && !email.equals(cliente.getEmail())){
			cliente.setEmail(email);
		}
		
		if (tfno != null && !tfno.equals(cliente.getTfno())){
			cliente.setTfno(tfno);
		}
		
		if (localidad != null && !localidad.equals(cliente.getLocalidad())){
			cliente.setLocalidad(localidad);
		}
		

		if (fechaNacimiento != null && !fechaNacimiento.equals(cliente.getFechaNacimiento().toString())){
			cliente.setFechaNacimiento(fechaNacimiento);
		}
		
		clienteCRMRepository.save(cliente);
	}
}
