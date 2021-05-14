package com.jubiter.logica;

import org.springframework.beans.factory.annotation.Autowired;

import com.jubiter.modelo.Producto;
import com.jubiter.exception.CantidadDeProductoInsuficienteException;
import com.jubiter.modelo.AlmacenEmpresa;
import com.jubiter.repository.ProductoRepository;


/**
 * Esta clase implementa las funcionalidades de las interfaces expuestas (especificadas
 * allí).
 * Sería interesante tener en cuenta el orden en las transacciones y controlar la concurrencia.
 * Por el tipo de proyecto que se ha ido planteando, sería lógico relacionarlo con el paso
 * de mensaje y eventos. Es decir un broker del tipo RabbitMQ, ya que se 
 * considera la solución más escalable y ordenada (pero se es consciente que no es la única).
 * 
 * Nota: no se ha podido invocar directamente en el código porque hay algún error en la 
 * comunicación entre los @Beans.
 * No me dió tiempo a analizarlo detenidamente, por eso se ha 'hardcodeado' momentáneamente
 * para mostrar la funcionalidad.
 * 
 * 
 * @author nr_alberto
 *
 */
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
