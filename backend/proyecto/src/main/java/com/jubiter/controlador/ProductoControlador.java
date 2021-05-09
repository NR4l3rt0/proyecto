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



/*
 * Esta clase no dispone de un método PUT, ya que sólo se considera modificar
 * el precio del producto. De ser más cosas, se deberá borrar y escribir uno nuevo.
 */
@RestController
@RequestMapping("/stock")
@CrossOrigin(origins = "http://localhost:3000")   // Permite el acceso desde el cliente
public class ProductoControlador {

	
	@Autowired
	private ProductoService productoService;

	
	
	
	@GetMapping("/productos")
	public List<Producto>getProductos() {
		return productoService.getAllProductos();
	}
	
	
	@GetMapping("/productos/{productoId}")
	public Producto getProducto(@PathVariable int productoId) {
		return productoService.getProducto(productoId);
	}
	
	
	
	@PostMapping("/productos")
	public void addProducto(@RequestBody Producto producto) {
		productoService.addProducto(producto);
	}
	
	
	
	
	@DeleteMapping("/productos/{productoId}")
	public void deleteCliente(@PathVariable int productoId) {
		productoService.deleteProducto(productoId);
	}
	

	// Solo modifica hasta dos decimales
	@PatchMapping(value = "/productos/{productoId}",
			  consumes = "application/json-patch+json")
	public void modifyCliente(
			    @PathVariable("productoId") int productoId,
			  	@RequestParam(required = false) BigDecimal precio,
			  	@RequestParam(required = false) Integer cantidad
			  	
			) {
		
		productoService.modifyProducto(productoId, precio, cantidad);	
	}		

	
}
