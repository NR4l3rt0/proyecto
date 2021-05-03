package com.jubiter.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "pedido_cliente")
public class PedidoCliente {
	
	/*@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "nro_pedido")
	private long nroPedido;*/
	
	@Id
	@Column(name = "id_pedido")
	private UUID idPedido;
	
	@Column(name = "elementos_pedido")
	private List<Producto> elementosPedido = new ArrayList<>();		// Se elige esta estructura por la posibilidad de modificaciones
	
	@Column(name = "estado_pedido")
	private String estadoPedido;
	
	@Column(name = "tipo_pedido")
	private String tipoPedido;
	
	@Column(name = "forma_pago")
	private String formaPago;
	
	@Column(name = "coste_pedido")
	private BigDecimal costePedido;
	
	@Column(name = "fecha_pedido")
	private LocalDate fechaPedido;
	
	@Column(name = "fecha_entrega")
	private LocalDate fechaEntrega;
	
	
    @ManyToOne(targetEntity = ClienteCRM.class, 
    		   cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinColumn(name = "id_nro_socio")
	private int nroSocio; 
	
    
    @ManyToOne(targetEntity = EmpleadoRRHH.class, 
    		   cascade = { CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH, CascadeType.REFRESH })
    @JoinColumn(name = "id_nro_empleado")
	private int nroEmpleado;
	
    
   @ManyToOne(targetEntity = AlmacenProducto.class,
		   	  cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "id_almacen")
	private int idAlmacen;		
    

   
   
    
    public PedidoCliente() {
    	this.idAlmacen = 1;				// De momento sólo hay uno
    }



	public PedidoCliente(UUID idPedido, List<Producto> elementosPedido, String estadoPedido, String tipoPedido,
			String formaPago, double costePedido, String fechaPedido, int nroSocio, int nroEmpleado) {
		super();
		this.idPedido = idPedido;
		this.elementosPedido = elementosPedido;
		this.estadoPedido = estadoPedido;
		this.tipoPedido = tipoPedido;
		this.formaPago = formaPago;

		this.nroSocio = nroSocio;
		this.nroEmpleado = nroEmpleado;
		
		setFechaPedido(fechaPedido);
		setCostePedido(costePedido);
		this.idAlmacen = 1;
	}




			
	

	public UUID getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(UUID idPedido) {
		this.idPedido = idPedido;
	}
	


	public List<Producto> getElementosPedido() {
		return elementosPedido;
	}

	public void setElementosPedido(List<Producto> elementosPedido) {
		this.elementosPedido = elementosPedido;
	}


	public String getEstadoPedido() {
		return estadoPedido;
	}

	public void setEstadoPedido(String estadoPedido) {
		this.estadoPedido = estadoPedido;
	}

	public String getTipoPedido() {
		return tipoPedido;
	}

	public void setTipoPedido(String tipoPedido) {
		this.tipoPedido = tipoPedido;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public BigDecimal getCostePedido() {
		return costePedido;
	}

	public void setCostePedido(double costePedido) {
		this.costePedido = BigDecimal.valueOf(costePedido);
	}
	
	public void setCostePedido(String costePedido) {
		this.costePedido = BigDecimal.valueOf(Double.valueOf(costePedido));
	}

	public LocalDate getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(String fechaPedido) {
		this.fechaPedido = LocalDate.parse(fechaPedido);
	}

	public LocalDate getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = LocalDate.parse(fechaEntrega);
	}

	public int getNroSocio() {
		return nroSocio;
	}

	public void setNroSocio(int nroSocio) {
		this.nroSocio = nroSocio;
	}

	public int getNroEmpleado() {
		return nroEmpleado;
	}

	public void setNroEmpleado(int nroEmpleado) {
		this.nroEmpleado = nroEmpleado;
	}

	public int getIdAlmacen() {
		return idAlmacen;
	}

	public void setIdAlmacen(int idAlmacen) {
		this.idAlmacen = idAlmacen;
	}
	

	
	@Override
	public String toString() {
		return "PedidoCliente [idPedido=" + idPedido + ", elementosPedido=" + elementosPedido + ", estadoPedido="
				+ estadoPedido + ", tipoPedido=" + tipoPedido + ", formaPago=" + formaPago + ", costePedido="
				+ costePedido + ", fechaPedido=" + fechaPedido + ", fechaEntrega=" + fechaEntrega + ", nroSocio="
				+ nroSocio + ", nroEmpleado=" + nroEmpleado + ", idAlmacen=" + idAlmacen + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPedido == null) ? 0 : idPedido.hashCode());
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
		PedidoCliente other = (PedidoCliente) obj;
		if (idPedido == null) {
			if (other.idPedido != null)
				return false;
		} else if (!idPedido.equals(other.idPedido))
			return false;
		return true;
	}
    
    
}
