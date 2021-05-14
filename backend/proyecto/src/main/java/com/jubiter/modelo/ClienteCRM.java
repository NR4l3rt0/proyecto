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
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.PastOrPresent;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.util.Set;

/**
 * Clase que modela al cliente y su interacción con el negocio.
 * Se establecen algunas restricciones mínimas a través de anotaciones.
 * 
 * Se relaciona con la clase {@link com.jubiter.modelo.PedidoCliente}, aunque está
 * abierta a otras posibilidades.
 * 
 * @author nr_alberto
 *
 */
@Entity
@Table(name = "cliente_crm")
public class ClienteCRM extends Persona {

	
	@Id
	@SequenceGenerator(
			name = "secuencia_cliente",		 						  
			sequenceName = "secuencia_cliente", 						 
			allocationSize = 1)
	@GeneratedValue( 
			strategy = GenerationType.SEQUENCE,	 						 
			generator = "secuencia_cliente")
	@Column(name = "pk_id_nro_socio")
	private Integer nroSocio;

	@FutureOrPresent								// Valida que la fecha es igual o superior al día actual
	@Column(name = "fecha_alta")
	private LocalDate fechaAlta; 

	@PastOrPresent									// fecha <= con respecto al día actual
	@Column(name = "fecha_baja")
	private LocalDate fechaBaja;

	@Column(name = "encuesta_hecha")
	private boolean encuestaHecha;

	@Lob // Nótese el mapeo a Text
	private String comentario;
	
	
	// Se dejan sin tomar los tipos de cascada pertenecientes al marco Hibernate,
	// así como la eliminación permanente.
	@JsonIgnore
	@OneToMany(mappedBy = "clienteCRM")
	private Set<PedidoCliente> pedidosCliente;

	
	public ClienteCRM() {
		super();
	}
	
	

	public ClienteCRM(Integer nroSocio) {
		super();
		this.nroSocio = nroSocio;
	}



	public ClienteCRM(Integer nroSocio, @FutureOrPresent LocalDate fechaAlta, @PastOrPresent LocalDate fechaBaja,
			boolean encuestaHecha, String comentario, Set<PedidoCliente> pedidosCliente) {
		super();
		this.nroSocio = nroSocio;
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
		this.encuestaHecha = encuestaHecha;
		this.comentario = comentario;
		this.pedidosCliente = pedidosCliente;
	}
	
	

	public ClienteCRM(@PastOrPresent LocalDate fechaAlta, @PastOrPresent LocalDate fechaBaja, boolean encuestaHecha,
			String comentario, String nombre, String apellidos, String tfno, String email, String sexo, String localidad,
			String estadoCivil, String estudio, String ocupacion, String hobby, LocalDate fechaNacimiento,
			boolean familiaNumerosa) {
		super(nombre, apellidos, tfno, email, sexo, localidad, estadoCivil, estudio, ocupacion, hobby, fechaNacimiento,
				familiaNumerosa);
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
		this.encuestaHecha = encuestaHecha;
		this.comentario = comentario;
	}

	
	
	public Integer getNroSocio() {
		return nroSocio;
	}

	public void setNroSocio(Integer nroSocio) {
		this.nroSocio = nroSocio;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public LocalDate getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(LocalDate fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public boolean isEncuestaHecha() {
		return encuestaHecha;
	}

	public void setEncuestaHecha(boolean encuestaHecha) {
		this.encuestaHecha = encuestaHecha;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Set<PedidoCliente> getPedidosCliente() {
		return pedidosCliente;
	}

	public void setPedidoCliente(Set<PedidoCliente> pedidosCliente) {
		this.pedidosCliente = pedidosCliente;
	}

	@Override
	public String toString() {
		return "ClienteCRM [nroSocio=" + nroSocio + ", fechaAlta=" + fechaAlta + ", fechaBaja=" + fechaBaja
				+ ", encuestaHecha=" + encuestaHecha + ", comentario=" + comentario + ", pedidosCliente=" + pedidosCliente
				+ ", getNombre()=" + getNombre() + ", getApellidos()=" + getApellidos() + ", getTfno()=" + getTfno()
				+ ", getEmail()=" + getEmail() + ", getSexo()=" + getSexo() + ", getLocalidad()=" + getLocalidad()
				+ ", getEstadoCivil()=" + getEstadoCivil() + ", getEstudio()=" + getEstudio() + ", getOcupacion()="
				+ getOcupacion() + ", getHobby()=" + getHobby() + ", getFechaNacimiento()=" + getFechaNacimiento()
				+ ", isFamiliaNumerosa()=" + isFamiliaNumerosa() + ", toString()=" + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((nroSocio == null) ? 0 : nroSocio.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClienteCRM other = (ClienteCRM) obj;
		if (nroSocio == null) {
			if (other.nroSocio != null)
				return false;
		} else if (!nroSocio.equals(other.nroSocio))
			return false;
		return true;
	}
	


	
	
	
	
	
}
