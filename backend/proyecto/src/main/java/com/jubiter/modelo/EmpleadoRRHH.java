package com.jubiter.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.EnumType;	Se descartó por motivos de tamaño al persistir,		
//import javax.persistence.Enumerated;	No obstante, se hubiera optado por implmentar una 
									 // Interfaz que haga la conversión (parece lo más efectivo)
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/**
 * Clase que permite modelar a todo tipo de empleado que esté en la empresa.
 * Hereda de persona, y será llamada desde el cliente para realizar el apartado de
 * analítica.
 * Permite ser visualizada a medida que se va modificando.
 * 
 * @author nr_alberto
 *
 */
@Entity
@Table(name = "empleado_rrhh")
public class EmpleadoRRHH extends Persona {

	
		@Id
		@SequenceGenerator(
				name = "secuencia_empleado",		 						  // nombre dado en Java
				sequenceName = "secuencia_empleado", 						  // secuencia creada BD (opcional si es = al nombre)
				allocationSize = 1 )				 					      // intervalo	
		@GeneratedValue( 
				strategy = GenerationType.SEQUENCE,	 						  // tipo del generador
				generator = "secuencia_empleado" )	 						  // nombre secuencia dado en Java	
		@Column(name="pk_id_nro_empleado")		
		private Integer nroEmpleado;
		
		//@Getter @Setter
		@Size(min = 8, max = 9, message = "Debe tener entre 8 y 9 valores")   // Se da pie a que la implementación 
		@Column(name="dni", unique = true)	  								  // use la letra o no; aunque para otro tipo
		private String dni;												      // de documento no español deba sufrir variaciones
		
		@Column(name="tipo_empleado")
		private String tipoEmpleado;
		
		@Column(name="jornada_trabajo")
		private String jornadaTrabajo;
	
		@PositiveOrZero														  // Valida que la cantidad se >= 0
		private BigDecimal salario;
		


		public EmpleadoRRHH() {
			super();
		}

		public EmpleadoRRHH(String nombre, String apellidos, String tfno, String email, String sexo, String localidad,
				String estadoCivil, String estudio, String ocupacion, String hobby, LocalDate fechaNacimiento,
				boolean familiaNumerosa, Integer nroEmpleado, String dni, String tipoEmpleado, String jornadaTrabajo,
				double salario) {
			super(nombre, apellidos, tfno, email, sexo, localidad, estadoCivil, estudio, ocupacion, hobby, fechaNacimiento,
					familiaNumerosa);
			this.nroEmpleado = nroEmpleado;
			this.dni = dni;
			this.tipoEmpleado = tipoEmpleado;
			this.jornadaTrabajo = jornadaTrabajo;
			setSalario(salario);
			
		}


		public EmpleadoRRHH(Integer clienteId, String nombre, String apellidos, String email, String tfno,
				String localidad, String fechaNacimiento, String sexo) {
			super(clienteId, nombre, apellidos, email, tfno, localidad, fechaNacimiento, sexo);

		}

		public EmpleadoRRHH(String nombre, String apellidos, String tfno, String email, String sexo, String localidad,
				String estadoCivil, String estudio, String ocupacion, String hobby, LocalDate fechaNacimiento,
				boolean familiaNumerosa) {
			super(nombre, apellidos, tfno, email, sexo, localidad, estadoCivil, estudio, ocupacion, hobby, fechaNacimiento,
					familiaNumerosa);

		}
		


		public EmpleadoRRHH(Integer nroEmpleado,
				@Size(min = 8, max = 9, message = "Debe tener entre 8 y 9 valores") String dni, String tipoEmpleado,
				String jornadaTrabajo, @PositiveOrZero BigDecimal salario) {
			super();
			this.nroEmpleado = nroEmpleado;
			this.dni = dni;
			this.tipoEmpleado = tipoEmpleado;
			this.jornadaTrabajo = jornadaTrabajo;
			this.salario = salario;
		}

		
		

		public void setSalario(double salario) {
			this.salario = BigDecimal.valueOf(salario);
		}

		public void setSalario(BigDecimal salario) {
			this.salario = salario;
		}

		public Integer getNroEmpleado() {
			return nroEmpleado;
		}

		public void setNroEmpleado(Integer nroEmpleado) {
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

		@Override
		public String toString() {
			return "EmpleadoRRHH [nroEmpleado=" + nroEmpleado + ", dni=" + dni + ", tipoEmpleado=" + tipoEmpleado
					+ ", jornadaTrabajo=" + jornadaTrabajo + ", salario=" + salario 
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
			result = prime * result + ((nroEmpleado == null) ? 0 : nroEmpleado.hashCode());
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
			EmpleadoRRHH other = (EmpleadoRRHH) obj;
			if (nroEmpleado == null) {
				if (other.nroEmpleado != null)
					return false;
			} else if (!nroEmpleado.equals(other.nroEmpleado))
				return false;
			return true;
		}
	

}
