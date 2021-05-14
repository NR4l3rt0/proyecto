package com.jubiter.logica;

import java.util.UUID;

import com.jubiter.modelo.AlmacenEmpresa;
import com.jubiter.modelo.PedidoCliente;
import com.jubiter.modelo.Producto;


/**
 * Interfaz que establece un contrato en el que se registrará la información que relaciona
 * un determinado producto con un pedido y un almacén.
 * Por tanto, serviría para llevar un control de esas tres entidades y su razón de ser 
 * es actuar como un enlace entre "módulos".
 * 
 * @author nr_alberto
 *
 */
public interface InsertorRegistroValido {

	public void registrarRegistro(Producto producto, PedidoCliente pedidoCliente, 
									AlmacenEmpresa almacenEmpresa);
}
