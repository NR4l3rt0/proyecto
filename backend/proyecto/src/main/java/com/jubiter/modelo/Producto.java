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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.PositiveOrZero;




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
	private int idProducto;
	
	private String nombre;
	private String categoria;
	
	@PositiveOrZero						// Se puede dar el caso que sea una oferta y salga gratis (o idea relacionada)
	private BigDecimal precio;
	private String proveedor;			// Podría ser tipo CIF(DNI) o nombre empresa
	
	@Column(name ="fecha_caducidad")
	private LocalDate fechaCaducidad;
	
	@Column(name = "cantidad_producto")
	private int cantidadProducto;
	
	@Id
	@ManyToOne(targetEntity = PedidoCliente.class,
			   cascade = { CascadeType.PERSIST, CascadeType.MERGE, 
			   			  CascadeType.DETACH, CascadeType.REFRESH },
			   fetch = FetchType.LAZY)
	@JoinColumn(name = "fkc_id_pedido")			// Relación con tabla PedidoCliente
	private PedidoCliente pedidoCliente;
	
	/*
	public void pedidosServidos(PedidoCliente pedido) {
		elementosPedido.add(pedido);
	}
	
	*/
	
	
	
	public Producto() {}
	
	
	public Producto(int idProducto, int cantidadProducto, double precio) {
		this.idProducto = idProducto;
		this.cantidadProducto = cantidadProducto;
		setPrecio(precio);
	}
	
	
	public Producto(int idProducto, String nombre, String categoria, BigDecimal precio, String proveedor,
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

	
	
	
	
	
	
	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = BigDecimal.valueOf(precio);
	}
	
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public LocalDate getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(LocalDate fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}
	
	public void setFechaCaducidad(String fechaCaducidad) {
		this.fechaCaducidad = LocalDate.parse(fechaCaducidad);
	}
	

	public int getCantidadProducto() {
		return cantidadProducto;
	}


	public void setCantidadProducto(int cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}

	

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", nombre=" + nombre + ", categoria=" + categoria + ", precio="
				+ precio + ", proveedor=" + proveedor + ", fechaCaducidad=" + fechaCaducidad + ", cantidadProducto="
				+ cantidadProducto + "]";
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idProducto;
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
		Producto other = (Producto) obj;
		if (idProducto != other.idProducto)
			return false;
		return true;
	}
	
	
	
	
	
	
}
