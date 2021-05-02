package com.jubiter.modelo;

import java.time.LocalDate;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.EnumType;	Se descartó por motivos de tamaño al persistir,		
//import javax.persistence.Enumerated;	No obstante, se hubiera optado por implmentar una 
									 // Interfaz que haga la conversión (parece lo más efectivo)
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




@Entity(name = "empleado_rrhh")
public class EmpleadoRRHH extends Persona {

	
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="id_nro_empleado", unique = true)		
		private int nroEmpleado;
		
		
		@Column(name="dni", unique = true)
		private String dni;
		
		@Column(name="tipo_empleado")
		private String tipoEmpleado;
		
		@Column(name="jornada_trabajo")
		private String jornadaTrabajo;
		
		private BigDecimal salario;
		
		
		

		public EmpleadoRRHH() {
			super();

		}
		


		public EmpleadoRRHH(String nombre, String apellidos, String tfno, String email, String sexo, String localidad,
				String estadoCivil, String estudio, String ocupacion, String hobby, LocalDate fechaNacimiento,
				boolean familiaNumerosa, int nroEmpleado, String dni, String tipoEmpleado, String jornadaTrabajo,
				int salario) {
			super(nombre, apellidos, tfno, email, sexo, localidad, estadoCivil, estudio, ocupacion, hobby, fechaNacimiento,
					familiaNumerosa);
			this.nroEmpleado = nroEmpleado;
			this.dni = dni;
			this.tipoEmpleado = tipoEmpleado;
			this.jornadaTrabajo = jornadaTrabajo;
			this.salario = new BigDecimal(salario);
		}


		public int getNroEmpleado() {
			return nroEmpleado;
		}


		public void setNroEmpleado(int nroEmpleado) {
			this.nroEmpleado = nroEmpleado;
		}


		public String getDni() {
			return dni;
		}


		public void setDni(String dni) {
			this.dni = dni;
		}


		public String getTipoEmpleado() {
			return tipoEmpleado;
		}


		public void setTipoEmpleado(String tipoEmpleado) {
			this.tipoEmpleado = tipoEmpleado;
		}


		public String getJornadaTrabajo() {
			return jornadaTrabajo;
		}


		public void setJornadaTrabajo(String jornadaTrabajo) {
			this.jornadaTrabajo = jornadaTrabajo;
		}


		public BigDecimal getSalario() {
			return salario;
		}


		public void setSalario(BigDecimal salario) {
			this.salario = salario;
		}
		
		public void setSalario(int salario) {
			this.salario = BigDecimal.valueOf(salario);
		}


		@Override
		public String toString() {
			return "EmpleadoRRHH [nroEmpleado=" + nroEmpleado + ", dni=" + dni + ", tipoEmpleado=" + tipoEmpleado
					+ ", jornadaTrabajo=" + jornadaTrabajo + ", salario=" + salario + ", nombre=" + getNombre() 
					+ ", apellidos=" + getApellidos() + ", tfno=" + getTfno() + ", email=" + getEmail() 
					+ ", sexo=" + getSexo() + ", localidad=" + getLocalidad() + ", estadoCivil= "
					+ getEstadoCivil() + ", estudio=" + getEstudio() + ", ocupacion=" + getOcupacion() 
					+ ", hobby=" + getHobby() + ", fechaNacimiento=" + getFechaNacimiento() 
					+ ", familiaNumerosa= " + isFamiliaNumerosa();
		}
		
		
		
		
}
