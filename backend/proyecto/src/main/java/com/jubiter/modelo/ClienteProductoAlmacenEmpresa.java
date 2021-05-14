package com.jubiter.modelo;


import java.util.UUID;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 * Implementa la clave primaria definida para el caso y se trata de una entidad
 * que persistirá en la base de datos.
 * 
 * De alguna manera esta relación ternaria se simplifica diviéndola en relaciones 1:M 
 * menores y bidireccionales.
 * 
 * De especial interés es el uso de las anotaciones, ya que Hibernate y Spring se comunican
 * a través de ellas.
 * 
 * @author nr_alberto
 *
 */
@Entity
@Table(name = "cliente_producto_almacen")
public class ClienteProductoAlmacenEmpresa {

	/**
	 * Materializa la clave personalizada, es decir, la identidad creada.
	 */
	@EmbeddedId
	private ClienteProductoAlmacenEmpresaCK idClienteProductoAlmacenCK;
	
	/**
	 * Orden lógico de estas anotaciones:
	 * Tipo de relación.
	 * Campo con el que se relaciona.
	 * Nombre con el que se identifica la columna en BD.
	 */
	@ManyToOne
	@MapsId("idAlmacen")
	@JoinColumn(name = "fk_id_almacen_empresa")
	private AlmacenEmpresa almacenEmpresa;
	
	@ManyToOne
	@MapsId("idProducto")
	@JoinColumn(name = "fk_id_producto")        
	private Producto producto;
	
	@ManyToOne
	@MapsId("idPedido")
	@JoinColumn(name = "fk_id_pedido_cliente")        
	private PedidoCliente pedidoCliente;
	
	private int cantidad;





	public ClienteProductoAlmacenEmpresa() {
		super();
	}


	public ClienteProductoAlmacenEmpresa(ClienteProductoAlmacenEmpresaCK idClienteProductoAlmacenCK) {
		super();
		this.idClienteProductoAlmacenCK = idClienteProductoAlmacenCK;
	}


	


	public ClienteProductoAlmacenEmpresa(ClienteProductoAlmacenEmpresaCK idClienteProductoAlmacenCK,
			AlmacenEmpresa almacenEmpresa, Producto producto, PedidoCliente pedidoCliente, int cantidad) {
		super();
		this.idClienteProductoAlmacenCK = idClienteProductoAlmacenCK;
		this.almacenEmpresa = almacenEmpresa;
		this.producto = producto;
		this.pedidoCliente = pedidoCliente;
		this.cantidad = cantidad;
	}


	public ClienteProductoAlmacenEmpresa(AlmacenEmpresa almacenEmpresa, Producto producto, PedidoCliente pedidoCliente) {
		super();
		this.almacenEmpresa = almacenEmpresa;
		this.producto = producto;
		this.pedidoCliente = pedidoCliente;
	}

	
	public ClienteProductoAlmacenEmpresa(ClienteProductoAlmacenEmpresaCK idClienteProductoAlmacenCK,
			AlmacenEmpresa almacenEmpresa, Producto producto, PedidoCliente pedidoCliente) {
		super();
		this.idClienteProductoAlmacenCK = idClienteProductoAlmacenCK;
		this.almacenEmpresa = almacenEmpresa;
		this.producto = producto;
		this.pedidoCliente = pedidoCliente;
	}






	public ClienteProductoAlmacenEmpresaCK getIdClienteProductoAlmacenCK() {
		return idClienteProductoAlmacenCK;
	}






	public void setIdClienteProductoAlmacenCK(ClienteProductoAlmacenEmpresaCK idClienteProductoAlmacenCK) {
		this.idClienteProductoAlmacenCK = idClienteProductoAlmacenCK;
	}






	public AlmacenEmpresa getAlmacenEmpresa() {
		return almacenEmpresa;
	}






	public void setAlmacenEmpresa(AlmacenEmpresa almacenEmpresa) {
		this.almacenEmpresa = almacenEmpresa;
	}






	public Producto getProducto() {
		return producto;
	}






	public void setProducto(Producto producto) {
		this.producto = producto;
	}






	public PedidoCliente getPedidoCliente() {
		return pedidoCliente;
	}







	public void setPedidoCliente(PedidoCliente pedidoCliente) {
		this.pedidoCliente = pedidoCliente;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}



	@Override
	public String toString() {
		return "ClienteProductoAlmacenEmpresa [idClienteProductoAlmacenCK=" + idClienteProductoAlmacenCK
				+ ", almacenEmpresa=" + almacenEmpresa + ", producto=" + producto + ", pedidoCliente=" + pedidoCliente
				+ ", cantidad=" + cantidad + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idClienteProductoAlmacenCK == null) ? 0 : idClienteProductoAlmacenCK.hashCode());
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
		ClienteProductoAlmacenEmpresa other = (ClienteProductoAlmacenEmpresa) obj;
		if (idClienteProductoAlmacenCK == null) {
			if (other.idClienteProductoAlmacenCK != null)
				return false;
		} else if (!idClienteProductoAlmacenCK.equals(other.idClienteProductoAlmacenCK))
			return false;
		return true;
	}


	
	
}

