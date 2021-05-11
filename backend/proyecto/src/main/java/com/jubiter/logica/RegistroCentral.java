package com.jubiter.logica;

import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.jubiter.modelo.AlmacenEmpresa;
import com.jubiter.modelo.PedidoCliente;
import com.jubiter.modelo.Producto;

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
	 
	@Override
	public void registrarRegistro(int idProducto, UUID idPedidoCliente, 
									int idAlmacen, int cantidadProducto) {
		
		jdbcTemplate.update("INSERT INTO cliente_producto_almacen "
				+ "(fk_id_producto, fk_id_pedido_cliente, fk_id_almacen_empresa,"
				+ "cantidad) VALUES(?,?,?,?)", 
				idProducto, idPedidoCliente, idAlmacen, cantidadProducto);
		
	}
	*/
	
	

}
