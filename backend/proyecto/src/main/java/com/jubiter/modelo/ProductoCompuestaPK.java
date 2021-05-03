package com.jubiter.modelo;

import java.io.Serializable;

public class ProductoCompuestaPK implements Serializable{

	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	
	
	private int idProducto;
	private PedidoCliente pedidoCliente;
	
	
	public ProductoCompuestaPK(){}
	
	public ProductoCompuestaPK(int idProducto, PedidoCliente pedidoCliente) {
		super();
		this.idProducto = idProducto;
		this.pedidoCliente = pedidoCliente;
	}





	public int getIdProducto() {
		return idProducto;
	}


	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}


	public PedidoCliente getPedidoCliente() {
		return pedidoCliente;
	}


	public void setPedidoCliente(PedidoCliente pedidoCliente) {
		this.pedidoCliente = pedidoCliente;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idProducto;
		result = prime * result + ((pedidoCliente == null) ? 0 : pedidoCliente.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductoCompuestaPK other = (ProductoCompuestaPK) obj;
		if (idProducto != other.idProducto)
			return false;
		if (pedidoCliente == null) {
			if (other.pedidoCliente != null)
				return false;
		} else if (!pedidoCliente.equals(other.pedidoCliente))
			return false;
		return true;
	}
	
	
	

	
	
	
	
	
	
}
