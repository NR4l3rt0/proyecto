package com.jubiter.logica;

import java.util.UUID;

import com.jubiter.modelo.AlmacenEmpresa;
import com.jubiter.modelo.PedidoCliente;
import com.jubiter.modelo.Producto;

public interface InsertorRegistroValido {

	public void registrarRegistro(Producto producto, PedidoCliente pedidoCliente, 
									AlmacenEmpresa almacenEmpresa);
}
