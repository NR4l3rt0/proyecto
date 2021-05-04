package com.jubiter.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



	
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass (ProductoCompuestaPK.class)
public class Producto {


	@Id
	@SequenceGenerator(
			name = "secuencia_producto",		 						  
			sequenceName = "secuencia_producto", 						
			allocationSize = 1					 					    
			)
	@GeneratedValue( 
			strategy = GenerationType.SEQUENCE,	 						 
			generator = "secuencia_producto"	 						 
			)
	@ManyToOne(targetEntity = AlmacenEmpresa.class,
			   cascade = { CascadeType.PERSIST, CascadeType.MERGE, 
					       CascadeType.DETACH, CascadeType.REFRESH },
			   fetch = FetchType.LAZY)
	@JoinColumn(name = "fkc_id_producto")        // Relación con tabla AlmacenEmpresa
	private Integer idProducto;
	
	
	@Id
	@ManyToOne(targetEntity = PedidoCliente.class,
			   cascade = { CascadeType.PERSIST, CascadeType.MERGE, 
			   			  CascadeType.DETACH, CascadeType.REFRESH },
			   fetch = FetchType.LAZY)
	@JoinColumn(name = "fkc_id_pedido")			// Relación con tabla PedidoCliente
	private PedidoCliente pedidoCliente;
	

	private String nombre;
	private String categoria;
	private String proveedor;			// Podría ser tipo CIF(DNI) o nombre empresa

	@PositiveOrZero						// Se puede dar el caso que sea una oferta y salga gratis (o idea relacionada)	
	private BigDecimal precio;

	@Column(name ="fecha_caducidad")	
	private LocalDate fechaCaducidad;
	
	@Column(name = "cantidad_producto")
	private int cantidadProducto;
	

	

	
	
	public Producto(Integer idProducto, int cantidadProducto, double precio) {
		this.idProducto = idProducto;
		this.cantidadProducto = cantidadProducto;
		setPrecio(precio);
	}
	
	
	public Producto(Integer idProducto, String nombre, String categoria, BigDecimal precio, String proveedor,
			LocalDate fechaCaducidad, int cantidadProducto) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.categoria = categoria;
		this.precio = precio;
		this.proveedor = proveedor;
		this.fechaCaducidad = fechaCaducidad;
		this.cantidadProducto = cantidadProducto;
	}

	
	public void setPrecio(double precio) {
		this.precio = BigDecimal.valueOf(precio);
	}

	public void fechaCaducidad (String fechaCaducidad) {
		this.fechaCaducidad = LocalDate.parse(fechaCaducidad);
	}
	
}
