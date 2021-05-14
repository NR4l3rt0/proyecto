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

import com.jubiter.modelo.ClienteCRM;
import com.jubiter.modelo.Producto;
import com.jubiter.service.ProductoService;



/**
 * Clase relacionada con el estado del producto. Permitiría las modificaciones
 * básicas.
 * Esta clase no dispone de un método PUT, ya que sólo se considera modificar
 * 
 * Las anotaciones indican que se trata de un controlador(RestController), 
 * el path al que responde (RequestMapping)
 * y el punto desde el que se permite el acceso (CrossOrigin). 
 * el precio del producto. De ser más cosas, se deberá borrar y escribir uno nuevo.
 */
@RestController
@RequestMapping("/stock")
@CrossOrigin(origins = "http://localhost:3000")   
public class ProductoControlador {

	/**
	 * La inyección de este servicio como atributo de la clase, conecta con los servicios
	 * y separa funcionalidades entre las partes del código.
	 */
	@Autowired
	private ProductoService productoService;

	
	
	/**
	 * Método HTTP GET
	 * @return devuelverá una lista de productos
	 */
	@GetMapping("/productos")
	public List<Producto>getProductos() {
		return productoService.getAllProductos();
	}
	
	/**
	 * Método HTTP GET
	 * @return devuelverá un único producto
	 */
	@GetMapping("/productos/{productoId}")
	public Producto getProducto(@PathVariable int productoId) {
		return productoService.getProducto(productoId);
	}
	
	
	/*
	 * Método HTTP POST
	 * Enlaza con el método que creará un producto en base a un conjunto de <K,V>,
	 * se piensa en JSON.
	 * Este es accedido a través del payload (body).
	 */
	@PostMapping("/productos")
	public void addProducto(@RequestBody Producto producto) {
		productoService.addProducto(producto);
	}
	
	
	
	/**
	 * Método HTTP DELETE
	 * Enlaza con el método que eliminará un producto en base a un ID.
	 * Este es accedido a través del path.
	 */
	@DeleteMapping("/productos/{productoId}")
	public void deleteCliente(@PathVariable int productoId) {
		productoService.deleteProducto(productoId);
	}
	

	
	/*
	 *  Método HTTP PATCH
	 * Enlaza con el método que permitirá modificar un producto en base a un ID 
	 * tomado de la variable PATH.
	 * Se especifica el tipo que se consume.
	 * Permite modificar el precio y la cantidad, pero se evita modificar la idententidad
	 * del producto.
	 * 
	 * El precio se ve modificado hasta dos decimales.
	 */
	@PatchMapping(value = "/productos/{productoId}",
			  	  consumes = "application/json-patch+json")
	public void modifyCliente(
			    @PathVariable("productoId") int productoId,
			  	@RequestParam(required = false) BigDecimal precio,
			  	@RequestParam(required = false) Integer cantidad
			  	
			) {
		
		// También podría pensarse en hacer un constructor que relacione estos campos
		// y pasar un objeto en vez de 3 parámetros (sería más elegante)
		productoService.modifyProducto(productoId, precio, cantidad);	
	}		

	
}
