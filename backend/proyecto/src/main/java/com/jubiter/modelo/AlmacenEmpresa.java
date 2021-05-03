package com.jubiter.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "almacen_empresa")
public class AlmacenEmpresa {

	@Id
	@SequenceGenerator(
			name = "secuencia_almacen_empresa",		 						 
			sequenceName = "secuencia_almacen_empresa", 						  
			allocationSize = 1					 					     
			)
	@GeneratedValue( 
			strategy = GenerationType.SEQUENCE,	 						  
			generator = "secuencia_almacen_empresa"	 						  
			)
	@Column(name = "pk_id_almacen")
	private int idAlmacen;
	
	
	@Column(name = "nombre_empresa")
	private String nombreEmpresa;
	
	
	// Una empresa trabaja con muchos productos y esos productos pertenecen a una empresa
	// Por el propósito del ejercicio se considera un almacén centralizado (luego distribuirá a los suyos internamente)
	@OneToMany(mappedBy = "idProducto",
			   cascade = { CascadeType.PERSIST, CascadeType.MERGE,
					   	   CascadeType.DETACH, CascadeType.REFRESH 
					  	 })
	@Column(name = "producto_by_id_list")
	private List<Producto> productoById = new ArrayList<>();
	

	

	
	/* Se considera esta relación porque uno o varios almacenes servirán muchos pedidos, 
	 * y un pedido podrá estar servido por muchos almacenes. 
	 * A su vez sirve para tomar la relación con los productos, un pedido tendrá muchos elementos,
	 * y un elemento podrá estar en muchos pedidos.  
	 * Por tanto, estaría tratando de materializar una doble relación entre estas dos entidades.
	 *
	 * Aquí se materializa la relación pedido-productos. (No tiene tanto importancia el almacén)
	 */
	/*@ManyToMany
	@Column(name = "elementos_pedido")
	private List<Producto> elementosPedido = new LinkedList<>();		
	*/
	
	
	

	
	
	
	/*
	@Column(name = "pedido_cliente")
	private UUID 
*/
	/*/@OneToMany(mappedBy = "idAlmacen", 
			   cascade = { CascadeType.PERSIST, CascadeType.MERGE,
						   CascadeType.DETACH, CascadeType.REFRESH 
						  })
	@Column(name = "pedido_cliente")
	private List<PedidoCliente> pedidoCliente = new ArrayList<>();*/
	
	
	
	public AlmacenEmpresa() {}





	public AlmacenEmpresa(int idAlmacen, List<Producto> productoById, String nombreEmpresa) {
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
