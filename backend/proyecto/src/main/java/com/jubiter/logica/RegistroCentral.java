package com.jubiter.logica;

import com.jubiter.modelo.AlmacenEmpresa;
import com.jubiter.modelo.PedidoCliente;
import com.jubiter.modelo.Producto;

public class RegistroCentral implements InsertorRegistroValido {
	
	/**
	 * Este método registrará en la BBDD el UUID del pedido del cliente, junto con la cantidad de cada producto y su ID;
	 * además del almacén desde el que se coje (en caso de que sea necesario).
	 */
	@Override
	public String registrarRegistro(Producto producto, PedidoCliente pedidoCliente, AlmacenEmpresa almacenEmpresa) {
		
		return "Por implementar";
	}
	
	
	

}
