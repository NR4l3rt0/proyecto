package com.jubiter.logica;

import org.springframework.beans.factory.annotation.Autowired;

import com.jubiter.modelo.Producto;
import com.jubiter.exception.CantidadDeProductoInsuficienteException;
import com.jubiter.modelo.AlmacenEmpresa;
import com.jubiter.repository.ProductoRepository;



public class RegistrarCantidadProducto implements ManagerDeExistencias, OrganizadorCantidadDePedidos{

	
	@Autowired
	public ProductoRepository productoRepository;
	
	@Override
	public void restarCantidadDeProducto(int idProducto, int cantidad) {
		
		throw new RuntimeException("hola?");
		
		//Producto producto = productoRepository.findById(idProducto);
		
		//throw new RuntimeException(producto.toString());
/*
		if(producto != null) {
			
			producto.setCantidad(producto.getCantidad() - cantidad);   // Se debería considerar la posible concurrencia
			
			productoRepository.save(producto);						   // Se hace un update del producto
			
		} else {
			throw new IllegalStateException("Producto no encontrado.");
		}
		
*/
		//return String.format("Cantidad actual del producto con ID %s: %s ", producto.getIdProducto(), producto.getCantidad());
		
	}

	
	/*
	 *  Realmente siempre va a ser uno ahora, pues sólo hay un almacén,
	 *  pero por manejar la posibilidad de múltiples almacenes. Iría iterando por los 
	 *  almacenes usando el findAll() o comprobaría un índice de productos. 
	 */
	@Override
	public AlmacenEmpresa buscarExistenciasAlmacenConcreto(int idProducto, int cantidad) throws CantidadDeProductoInsuficienteException {
		
		Producto producto = productoRepository.findById(idProducto);
		
		if(producto.getCantidad() < cantidad) {
			System.out.println("Existencias: " + producto.getCantidad() + ", cantidad requerida: " + cantidad);
			throw new CantidadDeProductoInsuficienteException("No hay suficiente cantidad para suplir el pedido. "
																+ "Genera los avisos correspondientes");
		}
		
	
		return new AlmacenEmpresa(1, "Jubiter S.L.");
	}
	

}
