package com.jubiter.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jubiter.exception.IdNoEncontradoException;
import com.jubiter.exception.ParseadoBigDecimalException;
import com.jubiter.modelo.Producto;
import com.jubiter.repository.ProductoRepository;



@Service
public class ProductoService {

	@Autowired
	private ProductoRepository productoRepository;
	
	
	public List<Producto>getAllProductos(){
		List<Producto> productos = new ArrayList<>();
		productoRepository.findAll()
						 	.forEach(productos::add);     

		return productos;
				
	}

	
	public Producto getProducto(int productoId){	
		
		boolean existe = productoRepository.existsById(productoId);
		
		if(!existe) {
			
			throw new IllegalStateException(
					"No existe un producto con ID: " + productoId);
		}
		
		return productoRepository.findById(productoId);	

	}
	

	
	public void addProducto(Producto producto) {
		
		if(producto.getProveedor().isBlank()) {
			throw new IllegalStateException(
					"Es necesario aportar un proveedor como mínimo");
		} else {
			productoRepository.save(producto);
		}
		
	}

	

	
	
	public void deleteProducto(int productoId) {
		
		boolean existe = productoRepository.existsById(productoId);
		
		if(!existe) {
			throw new IllegalStateException(
					"No existe un producto con ID: " + productoId);
		}
		
		productoRepository.deleteById(productoId);		// también sugerido en ClienteCRMRepository
		
	}


	public void modifyProducto(int productoId, BigDecimal precio) {
			
		Producto producto = productoRepository.findById(productoId);
		
		if(producto == null) {
			throw new IdNoEncontradoException(
						"No se ha encontrado ninguna coincidencia con ese ID.");
		}
		

		try {
			
			producto.setPrecio(precio);
			
		} catch (Exception e) {
	
			e.getStackTrace();
			throw new ParseadoBigDecimalException("El precio debe ser un campo numérico");
		}
			
		productoRepository.save(producto);
	}

}
