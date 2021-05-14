package com.jubiter.modelo;


import java.util.Set;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.PositiveOrZero;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entidad que modela el producto.
 * Esta clase es otro tipo de entidad que puede establecer muchas relaciones con otras
 * entidades según vaya evolucionando la lógica y necesidades del negocio.
 * Se han establecido algunas relaciones y se han sugerido otras. Por ejemplo, también
 * podría relacionarse con los proveedores de la empresa o competidores.
 * 
 * @author nr_alberto
 *
 */
@Entity
@Table
public class Producto {
	
	// Composición bidireccional por necesidad de implementación lógica de negocio (no se persiste, por eso Transient)
	@Transient
	private PedidoCliente pedidoCliente;
	
	@Id
	@SequenceGenerator(
			name = "secuencia_producto",		 						  
			sequenceName = "secuencia_producto", 						
			allocationSize = 1)
	@GeneratedValue( 
			strategy = GenerationType.SEQUENCE,	 						 
			generator = "secuencia_producto")
	@Column(name = "pk_id_producto")        // Relación con tabla AlmacenEmpresa
	private Integer idProducto;

	private String nombre;
	private String categoria;
	private String proveedor;			// Podría ser tipo CIF(DNI) o nombre empresa

	@Column(name ="fecha_caducidad")	
	private LocalDate fechaCaducidad;
	
	@Column(name = "cantidad_producto")
	private int cantidad;
	
	@PositiveOrZero						// Se puede dar el caso que sea una oferta y salga gratis (o idea relacionada)
	private BigDecimal precio;
	
	@JsonIgnore
	@OneToMany(mappedBy = "producto")
	private Set<ClienteProductoAlmacenEmpresa> clienteProductoAlmacenEmpresa;
	
	
	public Producto() {
		super();
	}

	
	
	public Producto(Integer idProducto, int cantidad) {
		super();
		this.idProducto = idProducto;
		this.cantidad = cantidad;
	}


	public Producto(String nombre, String categoria, String proveedor, String fechaCaducidad,
			int cantidad, @PositiveOrZero BigDecimal precio) {
		super();
		this.nombre = nombre;
		this.categoria = categoria;
		this.proveedor = proveedor;
		this.cantidad = cantidad;
		this.precio = precio;
		setFechaCaducidad(fechaCaducidad);

	}
	
	
	public Producto(String nombre, String categoria, String proveedor, LocalDate fechaCaducidad,
			int cantidad, @PositiveOrZero BigDecimal precio) {
		super();
		this.nombre = nombre;
		this.categoria = categoria;
		this.proveedor = proveedor;
		this.fechaCaducidad = fechaCaducidad;
		this.cantidad = cantidad;
		this.precio = precio;

	}
	
	public Producto(Integer idProducto, String nombre, String categoria, String proveedor, LocalDate fechaCaducidad,
			int cantidad, @PositiveOrZero BigDecimal precio) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.categoria = categoria;
		this.proveedor = proveedor;
		this.fechaCaducidad = fechaCaducidad;
		this.cantidad = cantidad;
		this.precio = precio;

	}
	
	public Producto(Integer idProducto, String nombre, String categoria, String proveedor, LocalDate fechaCaducidad,
			int cantidad, @PositiveOrZero BigDecimal precio,
			Set<ClienteProductoAlmacenEmpresa> clienteProductoAlmacenEmpresa) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.categoria = categoria;
		this.proveedor = proveedor;
		this.fechaCaducidad = fechaCaducidad;
		this.cantidad = cantidad;
		this.precio = precio;
		this.clienteProductoAlmacenEmpresa = clienteProductoAlmacenEmpresa;
	}


	public Integer getIdProducto() {
		return idProducto;
	}


	public void setIdProducto(Integer idProducto) {
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


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public BigDecimal getPrecio() {
		return precio;
	}


	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	
	public void setPrecio(String precio) {
		this.precio = BigDecimal.valueOf(Double.parseDouble(precio));
	}


	public Set<ClienteProductoAlmacenEmpresa> getClienteProductoAlmacenEmpresa() {
		return clienteProductoAlmacenEmpresa;
	}


	public void setClienteProductoAlmacenEmpresa(Set<ClienteProductoAlmacenEmpresa> clienteProductoAlmacenEmpresa) {
		this.clienteProductoAlmacenEmpresa = clienteProductoAlmacenEmpresa;
	}


	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", nombre=" + nombre + ", categoria=" + categoria + ", proveedor="
				+ proveedor + ", fechaCaducidad=" + fechaCaducidad + ", cantidad=" + cantidad + ", precio=" + precio
				+ ", clienteProductoAlmacenEmpresa=" + clienteProductoAlmacenEmpresa + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Producto other = (Producto) obj;
		if (idProducto == null) {
			if (other.idProducto != null)
				return false;
		} else if (!idProducto.equals(other.idProducto))
			return false;
		return true;
	}

	
	
	
	
}
