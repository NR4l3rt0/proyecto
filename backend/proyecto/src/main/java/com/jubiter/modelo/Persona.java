package com.jubiter.modelo;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Se aprovecha el concepto de herencia del paradigma OO y la particularidad
 * de PostgreSQL para usar la programación orientada a objetos.
 * De esta forma se ahorra repetir código y se trata de buscar la filosofía DRY.
 * 
 * Esta clase será implementada por {@link com.jubiter.modelo.EmpleadoRRHH} 
 * y  {@link com.jubiter.modelo.ClienteCRM}.
 * 
 * Es de interés de cara a rellenar encuestas y formularios.
 * 
 * @author nr_alberto
 *
 */
@MappedSuperclass
public class Persona {
	
	
	/*@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_persona")
	private int idPersona;*/
	private String nombre,  apellidos, 
				   sexo, localidad, estadoCivil, 
				   estudio, ocupacion, hobby;

	@NotBlank(message = "No puede ser una cadena vacía.")
	@Email								// Se asegura que el campo esté bien formado, aunque semánticamente dependa
	@Column/*(unique = true)	*/			// de la implementación
	private String email;
	
	@Column/*(unique = true)*/
	private String tfno;
	
	@Past								// Restringe el valor a una fecha del pasado
	@Column(name = "fecha_nacimiento")
	private LocalDate fechaNacimiento;
	@Column(name = "familia_numerosa")
	private boolean familiaNumerosa;
	
	/**
	 * Atributo derivado no persistido en la base de datos
	
	@Transient
	private Integer edad; */
	
	
	public Persona() {
		super();
	}



	public Persona(Integer clienteId, String nombre, String apellidos, String email,
			String tfno, String localidad, String fechaNacimiento, String sexo) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.tfno = tfno;
		this.email = email;
		this.sexo = sexo;
		this.localidad = localidad;
		this.fechaNacimiento = LocalDate.parse(fechaNacimiento);
		
	}


	public Persona(String nombre, String apellidos, String tfno, String email, String sexo, String localidad,
			String estadoCivil, String estudio, String ocupacion, String hobby, LocalDate fechaNacimiento, boolean familiaNumerosa) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.tfno = tfno;
		this.email = email;
		this.sexo = sexo;
		this.localidad = localidad;
		this.estadoCivil = estadoCivil;
		this.estudio = estudio;
		this.ocupacion = ocupacion;
		this.hobby = hobby;
		this.fechaNacimiento = fechaNacimiento;
		this.familiaNumerosa = familiaNumerosa;
	}


	
	
	
	
	
	

	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellidos() {
		return apellidos;
	}



	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}



	public String getTfno() {
		return tfno;
	}



	public void setTfno(String tfno) {
		this.tfno = tfno;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getSexo() {
		return sexo;
	}



	public void setSexo(String sexo) {
		this.sexo = sexo;
	}



	public String getLocalidad() {
		return localidad;
	}



	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}



	public String getEstadoCivil() {
		return estadoCivil;
	}



	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}



	public String getEstudio() {
		return estudio;
	}



	public void setEstudio(String estudio) {
		this.estudio = estudio;
	}



	public String getOcupacion() {
		return ocupacion;
	}



	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}



	public String getHobby() {
		return hobby;
	}



	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}



	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	/**
	 * Permite establecer la fecha en base a una cadena de texto 'YYYY-MM-DD'.
	 * 
	 * @param fechaNacimiento
	 */
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = LocalDate.parse(fechaNacimiento);
	}


	public boolean isFamiliaNumerosa() {
		return familiaNumerosa;
	}



	public void setFamiliaNumerosa(boolean familia_numerosa) {
		this.familiaNumerosa = familia_numerosa;
	}
	
	


	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellidos=" + apellidos + ", tfno=" + tfno + ", email=" + email
				+ ", sexo=" + sexo + ", localidad=" + localidad + ", estado_civ=" + estadoCivil + ", estudio=" + estudio
				+ ", ocupacion=" + ocupacion + ", hobby=" + hobby + ", edad=" + fechaNacimiento + ", familia_numerosa="
				+ familiaNumerosa + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		Persona other = (Persona) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}
	
	
	
	
	
	
	

}