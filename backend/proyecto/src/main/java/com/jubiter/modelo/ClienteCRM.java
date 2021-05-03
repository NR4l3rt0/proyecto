package com.jubiter.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.PastOrPresent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "cliente_crm")
public class ClienteCRM extends Persona {

	
	@Id
	@SequenceGenerator(
			name = "secuencia_cliente",		 						  
			sequenceName = "secuencia_cliente", 						 
			allocationSize = 1					 					     
			)
	@GeneratedValue( 
			strategy = GenerationType.SEQUENCE,	 						 
			generator = "secuencia_cliente"	 						 
			)
	@Column(name = "pk_id_nro_socio")
	private int nroSocio;

	@FutureOrPresent								// Valida que la fecha es igual o superior al día actual
	@Column(name = "fecha_alta")
	private LocalDate fechaAlta = LocalDate.now(); // Por defecto

	@PastOrPresent									// fecha <= con respecto al día actual
	@Column(name = "fecha_baja")
	private LocalDate fechaBaja;

	@Column(name = "encuesta_hecha")
	private boolean encuestaHecha;

	@Lob // Nótese el mapeo a Text
	private String comentario;
	
	
	// Se dejan sin tomar los tipos de cascada pertenecientes al marco Hibernate,
	// así como la eliminación permanente.
	@OneToMany(mappedBy = "nroSocio", 									
			   cascade = { CascadeType.PERSIST, CascadeType.MERGE,
						   CascadeType.DETACH, CascadeType.REFRESH 
						  })
	@Column(name = "pedido_cliente_list")
	private List<PedidoCliente> pedidoCliente = new ArrayList<>();
	


	public ClienteCRM(String nombre, String apellidos, String email, String tfno, String sexo, String localidad,
			String estadoCivil, String estudio, String ocupacion, String hobby, LocalDate fechaNacimiento,
			boolean familiaNumerosa, Integer nroSocio, LocalDate fechaBaja, boolean encuestaHecha, String comentario) {
		super(nombre, apellidos, tfno, email, sexo, localidad, estadoCivil, estudio, ocupacion, hobby, fechaNacimiento,
				familiaNumerosa);
		this.nroSocio = nroSocio;
		this.fechaBaja = fechaBaja;
		this.encuestaHecha = encuestaHecha;
		this.comentario = comentario;
		setFechaAlta();
	}




	public void setFechaAlta() { 					// Opciones de poner fecha automáticamente
		this.fechaAlta = LocalDate.now();
	}

	public void setFechaAlta(String fechaAlta) { 	// y mediante String
		this.fechaAlta = LocalDate.parse(fechaAlta);
	}

}
