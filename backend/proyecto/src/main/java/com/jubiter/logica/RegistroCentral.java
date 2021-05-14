package com.jubiter.logica;

import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.jubiter.modelo.AlmacenEmpresa;
import com.jubiter.modelo.PedidoCliente;
import com.jubiter.modelo.Producto;

/**
 * Esta clase mostraría otra foma de contactar con la BBDD, en este caso con un 
 * template. Éste tiene métodos interesantes que permiten escribir sentencias propias.
 * 
 * Se pretendería establecer una lógica que compruebe que todos los campos sean válidos, 
 * y se sugiere una forma de automatizar el proceso de registrar los libros de la empresa.
 * 
 * @author nr_alberto
 *
 */
@Component
public class RegistroCentral implements InsertorRegistroValido {
	
	
	private JdbcTemplate jdbcTemplate;

	@Override
	public void registrarRegistro(Producto producto, PedidoCliente pedidoCliente, AlmacenEmpresa almacenEmpresa) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	/**
	 * Este método registrará en la BBDD el UUID del pedido del cliente, junto con la cantidad de cada producto y su ID;
	 * además del almacén desde el que se coje (en caso de que sea necesario).
	 */
	/*
	@Override
	public void registrarRegistro(int idProducto, UUID idPedidoCliente, 
									int idAlmacen, int cantidadProducto) {
		
		jdbcTemplate.update("INSERT INTO cliente_producto_almacen "
				+ "(fk_id_producto, fk_id_pedido_cliente, fk_id_almacen_empresa,"
				+ "cantidad) VALUES(?,?,?,?)", 
				idProducto, idPedidoCliente, idAlmacen, cantidadProducto);
		
	}*/
	
	
	

}
