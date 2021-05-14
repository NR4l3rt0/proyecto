package com.jubiter.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jubiter.exception.IdNoEncontradoException;
import com.jubiter.exception.ParseadoBigDecimalException;
import com.jubiter.modelo.ClienteCRM;
import com.jubiter.modelo.Producto;
import com.jubiter.repository.ProductoRepository;


/**
 * Clase que implementa la lógica y relaciona el controlador con la BD.
 * Se apoya de un objeto del repositorio particular para facilitar las
 * transacciones.
 * Cosa que Spring había que hacer manualmente. 
 * 
 * @author nr_alberto
 *
 */
@Service
public class ProductoService {

	@Autowired
	private ProductoRepository productoRepository;
	
	/**
	 * Declara una lista, y con la ayuda del objeto del repositorio,
	 * que devuelve un conjunto de elementos, se irán agregando elementos iterativamente.
	 * Se usa un método con nomenclatura referencial (obj::método).
	 * 
	 * @return una lista de productos
	 */
	public List<Producto>getAllProductos(){
		List<Producto> productos = new ArrayList<>();
		productoRepository.findAll()
						 	.forEach(productos::add);     

		return productos;
				
	}

	/**
	 * La lógica es independiente de la implementación, en este caso se usa una lógica
	 * que chequea la existencia de un determinado producto. De existir se persiste, 
	 * si no, se lanza una excepción.
	 * 
	 * @param productoId
	 * @return un único producto que coincida con el valor del argumento que se pase
	 */
	public Producto getProducto(int productoId){	
		
		boolean existe = productoRepository.existsById(productoId);
		
		if(!existe) {
			
			throw new IllegalStateException(
					"No existe un producto con ID: " + productoId);
		}
		
		return productoRepository.findById(productoId);	

	}
	

	/**
	 * Añade un producto que vendrá definido por las propiedades del objeto 
	 * (en este caso JSON) que se pase. También influye el tipo de constructor que 
	 * se haya modelado.
	 * 
	 * Se pueden establecer los test que se necesiten para validar la entrada y enviar
	 * los mensajes que se necesiten.
	 * 
	 * @param producto
	 */
	public void addProducto(Producto producto) {
		
		if(producto.getProveedor().isBlank()) {
			throw new IllegalStateException(
					"Es necesario aportar un proveedor como mínimo");
		} else {
			productoRepository.save(producto);
		}
		
	}

	

	
	/**
	 * Elimina un producto en función de un ID.
	 * También sigue el mismo razonamiento de validación por existencia
	 * visto anteriormente.
	 * 
	 * @param productoId
	 */
	public void deleteProducto(int productoId) {
		
		boolean existe = productoRepository.existsById(productoId);
		
		if(!existe) {
			throw new IllegalStateException(
					"No existe un producto con ID: " + productoId);
		}
		
		productoRepository.deleteById(productoId);		// también sugerido en ClienteCRMRepository
		
	}

	/**
	 * Este método (relacionado con PATCH), permite modificar precio y cantidad en 
	 * función de un identificativo especificado.
	 * Se implementa trayendo el producto identificado con un ID de la base de datos, 
	 * y con los setters se modifican las propiedades que se requiran.
	 * 
	 * Es independiente de las validaciones que se quieran realizar.
	 * Se hacen uso, por ejemplo, de excepciones personalizadas vistas en el paquete
	 * correspondiente.
	 * 
	 * @param productoId
	 * @param precio
	 * @param cantidad
	 */
	public void modifyProducto(int productoId, BigDecimal precio, Integer cantidad  ) {
			
		Producto producto = productoRepository.findById(productoId);
		
		if(producto == null) {
			throw new IdNoEncontradoException(
						"No se ha encontrado ninguna coincidencia con ese ID.");
		}
		

		try {
			/*
			 * Chequea si el valor no sea null, ni igual ni menor o igual a cero
			 */
			if(precio != null && 
			   precio != producto.getPrecio() && 
			   precio.doubleValue() > 0) {
					producto.setPrecio(precio);
			}
			
			
		} catch (Exception e) {
	
			e.getStackTrace();
			throw new ParseadoBigDecimalException("El precio debe ser un campo numérico");
		}
		
		
		try {
			
			if(cantidad > 0 &&
			   cantidad != producto.getCantidad()) {
				producto.setCantidad(cantidad);
			}
			
			
		} catch (Exception e) {
	
			e.getStackTrace();
			
		}
		
		
			
		productoRepository.save(producto);
	}


}
