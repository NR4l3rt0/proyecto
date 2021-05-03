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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data				// Se usa Lombok
@NoArgsConstructor
@AllArgsConstructor
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
	
}
	
