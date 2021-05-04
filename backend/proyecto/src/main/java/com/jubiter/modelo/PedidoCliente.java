package com.jubiter.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@Table(name = "pedido_cliente")
public class PedidoCliente {
	
	
	/*@SequenceGenerator(
			name = "secuencia_pedidos",		 						  
			sequenceName = "secuencia_pedidos", 						
			allocationSize = 1 )
	@GeneratedValue( 
			strategy = GenerationType.SEQUENCE,	 						 
			generator = "secuencia_pedidos")*/
	@Id
	@GeneratedValue
	@Column(name = "pk_id_pedido")
	private UUID idPedido;
	
	
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
    		   cascade = { CascadeType.PERSIST, CascadeType.MERGE, 
    				   	   CascadeType.DETACH, CascadeType.REFRESH })
    @JoinColumn(name = "fk_id_nro_socio")
	private Integer nroSocio; 
	
    
    @ManyToOne(targetEntity = EmpleadoRRHH.class, 
    		   cascade = { CascadeType.PERSIST, CascadeType.MERGE,
    				   	   CascadeType.DETACH, CascadeType.REFRESH })
    @JoinColumn(name = "fk_id_nro_empleado")
	private Integer nroEmpleado;
	
    
   @ManyToOne(targetEntity = AlmacenEmpresa.class,
		   	  cascade = { CascadeType.PERSIST, CascadeType.MERGE, 
		   			  	  CascadeType.DETACH, CascadeType.REFRESH })
    @JoinColumn(name = "fk_id_almacen")
	private Integer idAlmacen;		
    
   
   
   //Relación con tabla producto, bidireccional
   @OneToMany(mappedBy = "pedidoCliente",
		   	  cascade = { CascadeType.PERSIST, CascadeType.MERGE,
				   	   	  CascadeType.DETACH, CascadeType.REFRESH 
			  	 	    })
   @Column(name = "elementos_pedido_set", nullable = false)
   private Set<Producto> elementosPedido;
   
   
  
   
   
    
    public PedidoCliente() {
    	super();
    	this.idAlmacen = 1;				// De momento sólo hay uno
    }



	public PedidoCliente(UUID idPedido, String estadoPedido, String tipoPedido,
			String formaPago, double costePedido, String fechaPedido, Integer nroSocio, Integer nroEmpleado) {
		super();
		this.idPedido = idPedido;

		this.estadoPedido = estadoPedido;
		this.tipoPedido = tipoPedido;
		this.formaPago = formaPago;

		this.nroSocio = nroSocio;
		this.nroEmpleado = nroEmpleado;
		
		setFechaPedido(fechaPedido);
		setCostePedido(costePedido);
		this.idAlmacen = 1;
	}
	
	public PedidoCliente (UUID idPedido, BigDecimal costePedido, String estadoPedido,
						LocalDate fechaEntrega, LocalDate fechaPedido, String formaPago, String tipoPedido,
						Integer idAlmacen, Integer nroEmpleado, Integer nroSocio) {
		this.idPedido = idPedido;
		this.costePedido = costePedido;
		this.estadoPedido = estadoPedido;
		this.fechaEntrega = fechaEntrega;
		this.fechaPedido = fechaPedido;
		this.tipoPedido = tipoPedido;
		this.idAlmacen = idAlmacen;
		this.nroEmpleado = nroEmpleado;
		this.nroSocio = nroSocio;

	}



	public void setCostePedido(double costePedido) {
		this.costePedido = BigDecimal.valueOf(costePedido);
	}
	
	public void setCostePedido(String costePedido) {
		this.costePedido = BigDecimal.valueOf(Double.valueOf(costePedido));
	}


	public void setFechaPedido(String fechaPedido) {
		this.fechaPedido = LocalDate.parse(fechaPedido);
	}


	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = LocalDate.parse(fechaEntrega);
	}


    
}
