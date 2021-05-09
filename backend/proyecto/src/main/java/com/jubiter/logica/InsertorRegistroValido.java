package com.jubiter.logica;

import com.jubiter.modelo.AlmacenEmpresa;
import com.jubiter.modelo.PedidoCliente;
import com.jubiter.modelo.Producto;

public interface InsertorRegistroValido {

	public String registrarRegistro(Producto producto, PedidoCliente pedidoCliente, AlmacenEmpresa almacenEmpresa);
}
