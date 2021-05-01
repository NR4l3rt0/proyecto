package com.jubiter.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jubiter.modelo.ClienteCRM;
import com.jubiter.repository.ClienteCRMRepository;


@Service
public class ClienteCRMService {
	
	
	@Autowired
	private ClienteCRMRepository clienteCRMRepository;  // Inyección
	
	
	public List<ClienteCRM>getAllClientes(){
		List<ClienteCRM> clientes = new ArrayList<>();
		clienteCRMRepository.findAll()
						 	.forEach(clientes::add);     // llamada por referencia al método del tipo

		return clientes;
				
	}

	
	public ClienteCRM getCliente(int id){
		return clienteCRMRepository.findById(id);	// método sugerido en ClienteCRMRepository
	}
	

	public void addCliente(ClienteCRM cliente) {
		clienteCRMRepository.save(cliente);
		
	}


	public void updateCliente(int id, ClienteCRM cliente) {
		clienteCRMRepository.save(cliente);
				
	}

	
	public void deleteCliente(int id) {
		
		//personaRepository.delete(personaRepository.findByNombre(id));
		clienteCRMRepository.deleteById(id);		// también sugerido en ClienteCRMRepository
		
	}
	

}
