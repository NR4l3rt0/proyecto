package com.jubiter.modelo;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embeddable;


/**
 * Clase serializable que sirve para establecer la clave primaria compuesta.
 * Es necesario que existan las propiedades a agrupar, constructores, getters/setters,
 * control equals sobreescribiendo el hashcode, y que sea Serializable.
 * 
 * @author nr_alberto
 *
 */
@Embeddable
public class ClienteProductoAlmacenEmpresaCK implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7146323861463679977L;

	@Column(name = "pk_id_almacen")
	private Integer idAlmacen;
	
	@Column(name = "pk_id_producto")       
	private Integer idProducto;
	
	@Column(name = "pk_id_pedido")
	private UUID idPedido;

	
	public ClienteProductoAlmacenEmpresaCK() {
		super();
	}
	
	public ClienteProductoAlmacenEmpresaCK(Integer idAlmacen, Integer idProducto, UUID idPedido) {
		super();
		this.idAlmacen = idAlmacen;
		this.idProducto = idProducto;
		this.idPedido = idPedido;
	}

	public Integer getIdAlmacen() {
		return idAlmacen;
	}

	public void setIdAlmacen(Integer idAlmacen) {
		this.idAlmacen = idAlmacen;
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public UUID getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(UUID idPedido) {
		this.idPedido = idPedido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAlmacen == null) ? 0 : idAlmacen.hashCode());
		result = prime * result + ((idPedido == null) ? 0 : idPedido.hashCode());
		result = prime * result + ((idProducto == null) ? 0 : idProducto.hashCode());
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
		ClienteProductoAlmacenEmpresaCK other = (ClienteProductoAlmacenEmpresaCK) obj;
		if (idAlmacen == null) {
			if (other.idAlmacen != null)
				return false;
		} else if (!idAlmacen.equals(other.idAlmacen))
			return false;
		if (idPedido == null) {
			if (other.idPedido != null)
				return false;
		} else if (!idPedido.equals(other.idPedido))
			return false;
		if (idProducto == null) {
			if (other.idProducto != null)
				return false;
		} else if (!idProducto.equals(other.idProducto))
			return false;
		return true;
	}

	
	
}
