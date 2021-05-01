package com.jubiter.modelo;

import java.time.LocalDate;
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


/*
 * 
 * 
 * Es importante ver la estrategia que se pretende seguir, se elije que esté todo en 
 * una tabla por motivo de rapidez de acceso. Por tanto, se separan por el discriminador
 * Así,se da más flexibilidad en la inserción de datos.
 * Sin embargo, habrá que implementar las restricciones oportunas a nivel de lógica
 * en la aplicación, o desde la interfaz gráfica.
 * 
 *
 * @Entity(name ="persona")
 *
 * @DiscriminatorColumn(
 * 	name = "relacionEmpresa",
 * 	discriminatorType = DiscriminatorType.STRING
 * 	)
 * @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
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
	
	//tfno, email,
	@Column(unique = true)
	private String email;
	
	@Column(unique = true)
	private String tfno;
	
	@Column(name = "fecha_nacimiento")
	private LocalDate fechaNacimiento;
	@Column(name = "familia_numerosa")
	private boolean familiaNumerosa;
	
	
	
	public Persona() {}



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

	/*
	// Ayuda a ponerlo desde el constructor
	public LocalDate setGetFechaNacimiento(String fechaNacimiento) {
		this.setFechaNacimiento(fechaNacimiento);
		return this.getFechaNacimiento();
	}
	*/
	


	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}



	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
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

}