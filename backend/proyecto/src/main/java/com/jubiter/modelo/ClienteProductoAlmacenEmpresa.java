package com.jubiter.modelo;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "cliente_producto_almacen")
public class ClienteProductoAlmacenEmpresa {

	
	@EmbeddedId
	private ClienteProductoAlmacenEmpresaCK idClienteProductoAlmacenCK;
	
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
	
	
	



	public ClienteProductoAlmacenEmpresa() {
		super();
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






	@Override
	public String toString() {
		return "ClienteProductoAlmacenEmpresa [idClienteProductoAlmacenCK=" + idClienteProductoAlmacenCK
				+ ", almacenEmpresa=" + almacenEmpresa + ", producto=" + producto + ", pedidoCliente=" + pedidoCliente
				+ "]";
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

