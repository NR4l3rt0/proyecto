package com.jubiter.modelo;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class PedidoCliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name= "nro_pedido")
	private UUID nroPedido;
	
	@Column(name = "estado_pedido")
	private String estadoPedido;
	
	@Column(name = "tipo_pedido")
	private String tipoPedido;
	
	@Column(name = "forma_pago")
	private String formaPago;
	
	@Column(name = "coste_pedido")
	private String costePedido;
	
	@Column(name = "fecha_pedido")
	private LocalDate fechaPedido;
	
	@Column(name = "fecha_entrega")
	private LocalDate fechaEntrega;
	
	@Column(name = "fk_nro_socio")
	private int nroSocio; 
	
	@Column(name = "fk_nro_empleado")
	private int nroEmpleado;
}
