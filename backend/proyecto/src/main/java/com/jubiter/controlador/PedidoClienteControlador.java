package com.jubiter.controlador;

import java.util.List;
import java.util.UUID;

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

import com.jubiter.modelo.ClienteCRM;
import com.jubiter.modelo.PedidoCliente;
import com.jubiter.service.ClienteCRMService;
import com.jubiter.service.PedidoClienteService;

/**
 * Esta clase implementa simplemente el servicio que permitirá ver una variación
 * en la cantidad del producto.
 * Así tanto el cliente como el empleado que controle la mercancía podrá hacer el seguimiento
 * casi en tiempo real.
 * No obstante, se presentan problemas que se deberían considerar para implementar los otros 
 * servicios: cómo se ve envuelto el objeto UUID, el flujo de streams, y el concepto 'transient'
 * 
 * @author nr_alberto
 *
 */
@RestController
@RequestMapping("/area-cliente")
@CrossOrigin(origins = "http://localhost:3000") 
public class PedidoClienteControlador {


	@Autowired
	private PedidoClienteService pedidoClienteService;

	
	@PostMapping("/mis-pedidos")
	public void addCliente(@RequestBody PedidoCliente pedidoCliente) {

	pedidoClienteService.addPedidoCliente(pedidoCliente);
}

	
	
	
	/*
	 Problema transient
	
	@GetMapping("/mi-lista-pedidos")
	public List<PedidoCliente>getMisPedidos(ClienteCRM clienteCRM) {
		return pedidoClienteService.getAllPedidoCliente(clienteCRM);
	}
	
	Problema Stream (lob) -> tal vez se deba hacer desde cliente
	
	@GetMapping("/mis-productos/{idPedidoCliente}")
	public List<PedidoCliente> getMiPedido(@PathVariable UUID idPedidoCliente) {
		return pedidoClienteService.getPedidoCliente(idPedidoCliente);
	}
	

	@DeleteMapping("/mis-pedidos/{idPedidoCliente}")
	public void deleteCliente(@PathVariable UUID idPedidoCliente) {
		pedidoClienteService.deletePedidoCliente(idPedidoCliente);
	}
	*/
	


	
	
	
}
