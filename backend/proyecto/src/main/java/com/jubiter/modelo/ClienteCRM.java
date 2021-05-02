package com.jubiter.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import java.time.LocalDate;
import java.util.UUID;

//@DiscriminatorValue("Cliente")
@Entity(name = "cliente_crm")
public class ClienteCRM extends Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_nro_socio")
	private int nroSocio;

	@Column(name = "fecha_alta")
	private LocalDate fechaAlta = LocalDate.now(); // Por defecto

	@Column(name = "fecha_baja")
	private LocalDate fechaBaja;

	@Column(name = "encuesta_hecha")
	private boolean encuestaHecha;

	@Lob // Nótese el mapeo a Text
	private String comentario;
	

	public ClienteCRM() {
	}

	public ClienteCRM(String nombre, String apellidos, String email, String tfno, String sexo, String localidad,
			String estadoCivil, String estudio, String ocupacion, String hobby, LocalDate fechaNacimiento,
			boolean familiaNumerosa, Integer nroSocio, LocalDate fechaBaja, boolean encuestaHecha, String comentario) {
		super(nombre, apellidos, tfno, email, sexo, localidad, estadoCivil, estudio, ocupacion, hobby, fechaNacimiento,
				familiaNumerosa);
		this.nroSocio = nroSocio;
		this.fechaBaja = fechaBaja;
		this.encuestaHecha = encuestaHecha;
		this.comentario = comentario;
	}



	public int getNroSocio() {
		return nroSocio;
	}

	public void setNroSocio(int nroSocio) {
		this.nroSocio = nroSocio;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta() { // Opciones de poner fecha automáticamente
		this.fechaAlta = LocalDate.now();
	}

	public void setFechaAlta(String fechaAlta) { // y mediante String
		this.fechaAlta = LocalDate.parse(fechaAlta);
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

	@Override
	public String toString() {
		return "ClienteCRM [nroSocio=" + nroSocio + ", fechaAlta=" + fechaAlta + ", fechaBaja=" + fechaBaja
				+ ", encuestaHecha=" + encuestaHecha + ", comentario=" + comentario + ", nombre=" + getNombre()
				+ ", apellidos=" + getApellidos() + ", tfno=" + getTfno() + ", email=" + getEmail() + ", sexo="
				+ getSexo() + ", localidad=" + getLocalidad() + ", estadoCivil=" + getEstadoCivil() + ", estudio="
				+ getEstudio() + ", ocupacion=" + getOcupacion() + ", hobby=" + getHobby() + ", fechaNacimiento="
				+ getFechaNacimiento() + ", familiaNumerosa=" + isFamiliaNumerosa();
	}


}
