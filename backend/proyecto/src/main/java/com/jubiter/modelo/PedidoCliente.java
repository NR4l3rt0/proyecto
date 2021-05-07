package com.jubiter.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "pedido_cliente")
public class PedidoCliente {

	@Id
	@GeneratedValue
	@Column(name = "pk_id_pedido_cliente")
	private UUID idPedidoCliente;
	
	
	@Column(name = "estado")
	private String estado;
	
	@Column(name = "prioridad")
	private String prioridad;
	
	@Column(name = "forma_pago")
	private String formaPago;
	
	@Column(name = "coste_total")
	private BigDecimal costeTotal;
	
	@Column(name = "fecha_emision")
	private LocalDate fechaEmision;
	
	@Column(name = "fecha_entrega")
	private LocalDate fechaEntrega;
	
	@JsonIgnore
    @OneToMany(mappedBy = "pedidoCliente")
	private Set<ClienteProductoAlmacenEmpresa> clienteProductoAlmacenEmpresa; 
    
    
	
    @ManyToOne(targetEntity = ClienteCRM.class)
    @JoinColumn(name = "fk_id_nro_socio")
	private ClienteCRM clienteCRM; 
    
    
    
    public PedidoCliente() {
    	super();
    }


	public PedidoCliente(String estado, String prioridad, String formaPago, BigDecimal costeTotal,
			LocalDate fechaEmision) {
		super();
		this.estado = estado;
		this.prioridad = prioridad;
		this.formaPago = formaPago;
		this.costeTotal = costeTotal;
		this.fechaEmision = fechaEmision;
	}
    
    
    
	public PedidoCliente(UUID idPedidoCliente, String estado, String prioridad, String formaPago, BigDecimal costeTotal,
			LocalDate fechaEmision) {
		super();
		this.idPedidoCliente = idPedidoCliente;
		this.estado = estado;
		this.prioridad = prioridad;
		this.formaPago = formaPago;
		this.costeTotal = costeTotal;
		this.fechaEmision = fechaEmision;
	}
	
	public PedidoCliente(UUID idPedidoCliente, String estado, String prioridad, String formaPago, BigDecimal costeTotal,
			LocalDate fechaEmision, ClienteCRM clienteCRM) {
		super();
		this.idPedidoCliente = idPedidoCliente;
		this.estado = estado;
		this.prioridad = prioridad;
		this.formaPago = formaPago;
		this.costeTotal = costeTotal;
		this.fechaEmision = fechaEmision;
		this.clienteCRM = clienteCRM;
	}


	public PedidoCliente(UUID idPedidoCliente, String estado, String prioridad, String formaPago, BigDecimal costeTotal,
			LocalDate fechaEmision, LocalDate fechaEntrega,
			Set<ClienteProductoAlmacenEmpresa> clienteProductoAlmacenEmpresa, ClienteCRM clienteCRM) {
		super();
		this.idPedidoCliente = idPedidoCliente;
		this.estado = estado;
		this.prioridad = prioridad;
		this.formaPago = formaPago;
		this.costeTotal = costeTotal;
		this.fechaEmision = fechaEmision;
		this.fechaEntrega = fechaEntrega;
		this.clienteProductoAlmacenEmpresa = clienteProductoAlmacenEmpresa;
		this.clienteCRM = clienteCRM;
	}






	public UUID getIdPedidoCliente() {
		return idPedidoCliente;
	}



	public void setIdPedidoCliente(UUID idPedidoCliente) {
		this.idPedidoCliente = idPedidoCliente;
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}



	public String getPrioridad() {
		return prioridad;
	}



	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}



	public String getFormaPago() {
		return formaPago;
	}



	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}



	public BigDecimal getCosteTotal() {
		return costeTotal;
	}



	public void setCosteTotal(BigDecimal costeTotal) {
		this.costeTotal = costeTotal;
	}



	public LocalDate getFechaEmision() {
		return fechaEmision;
	}



	public void setFechaEmision(LocalDate fechaEmision) {
		this.fechaEmision = fechaEmision;
	}



	public LocalDate getFechaEntrega() {
		return fechaEntrega;
	}



	public void setFechaEntrega(LocalDate fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}



	public Set<ClienteProductoAlmacenEmpresa> getClienteProductoAlmacenEmpresa() {
		return clienteProductoAlmacenEmpresa;
	}



	public void setClienteProductoAlmacenEmpresa(Set<ClienteProductoAlmacenEmpresa> clienteProductoAlmacenEmpresa) {
		this.clienteProductoAlmacenEmpresa = clienteProductoAlmacenEmpresa;
	}




	@Override
	public String toString() {
		return "PedidoCliente [idPedidoCliente=" + idPedidoCliente + ", estado=" + estado + ", prioridad=" + prioridad
				+ ", formaPago=" + formaPago + ", costeTotal=" + costeTotal + ", fechaEmision=" + fechaEmision
				+ ", fechaEntrega=" + fechaEntrega + ", clienteProductoAlmacenEmpresa=" + clienteProductoAlmacenEmpresa
				+ "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPedidoCliente == null) ? 0 : idPedidoCliente.hashCode());
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
		if (idPedidoCliente == null) {
			if (other.idPedidoCliente != null)
				return false;
		} else if (!idPedidoCliente.equals(other.idPedidoCliente))
			return false;
		return true;
	}

    
	
    
}
