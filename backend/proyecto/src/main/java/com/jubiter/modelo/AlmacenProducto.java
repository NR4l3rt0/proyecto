package com.jubiter.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "almacen_productos")
public class AlmacenProducto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_almacen")
	private int idAlmacen;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_id_almacen_producto")
	@Column(name = "producto_by_id")
	private List<Producto> productoById = new ArrayList<>();
	
	@Column(name = "nombre_empresa")
	private String nombreEmpresa;

	
	
	
	
	public AlmacenProducto() {}





	public AlmacenProducto(int idAlmacen, List<Producto> productoById, String nombreEmpresa) {
		super();
		this.idAlmacen = idAlmacen;
		this.productoById = productoById;
		this.nombreEmpresa = nombreEmpresa;
	}




	public int getIdAlmacen() {
		return idAlmacen;
	}


	public void setIdAlmacen(int idAlmacen) {
		this.idAlmacen = idAlmacen;
	}


	public List<Producto> getProductoById() {
		return productoById;
	}


	public void setProductoById(List<Producto> productoById) {
		this.productoById = productoById;
	}


	public String getNombreEmpresa() {
		return nombreEmpresa;
	}


	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	

	@Override
	public String toString() {
		return "AlmacenProductos [idAlmacen=" + idAlmacen + ", productoById=" + productoById
				+ ", nombreEmpresa=" + nombreEmpresa + "]";
	}


	
	
}
