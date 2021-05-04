package com.jubiter.modelo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data				
@NoArgsConstructor
@AllArgsConstructor
public class ProductoCompuestaPK implements Serializable{


	private static final long serialVersionUID = 1L;

	/*
	 *  IMPORTANTE: 
	 *  - Esta clase necesita definir el constructor completo, el por defecto, getters/setters,
	 *    y HashCode/Equals.
	 *    Quedan definidos mediante anotaciones con Lombok
	 */
	
	
	private Integer idProducto;
	private PedidoCliente pedidoCliente;
	

}
