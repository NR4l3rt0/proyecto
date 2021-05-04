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


@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@AllArgsConstructor
@Entity(name = "empleado_rrhh")
public class EmpleadoRRHH extends Persona {

	
		@Id
		@SequenceGenerator(
				name = "secuencia_empleado",		 						  // nombre dado en Java
				sequenceName = "secuencia_empleado", 						  // secuencia creada BD (opcional si es = al nombre)
				allocationSize = 1 )				 					      // intervalo
				
		@GeneratedValue( 
				strategy = GenerationType.SEQUENCE,	 						  // tipo del generador
				generator = "secuencia_empleado" )	 						  // nombre secuencia dado en Java	
		@Getter @Setter
		@Column(name="pk_id_nro_empleado")		
		private Integer nroEmpleado;
		
		@Getter @Setter
		@Size(min = 8, max = 9, message = "Debe tener entre 8 y 9 valores")   // Se da pie a que la implementación 
		@Column(name="dni", unique = true)	  								  // use la letra o no; aunque para otro tipo
		private String dni;												      // de documento no español deba sufrir variaciones
		
		@Getter @Setter
		@Column(name="tipo_empleado")
		private String tipoEmpleado;
		
		@Getter @Setter
		@Column(name="jornada_trabajo")
		private String jornadaTrabajo;
		
		@Getter
		@PositiveOrZero														  // Valida que la cantidad se >= 0
		private BigDecimal salario;
		
		@OneToMany(mappedBy = "nroEmpleado", 
				   cascade = { CascadeType.PERSIST, CascadeType.MERGE,
							   CascadeType.DETACH, CascadeType.REFRESH 
							  })
		@Getter @Setter
		@Column(name = "pedido_cliente_list")		// esto parece que no sirve para nada
		private List<PedidoCliente> pedidoCliente = new ArrayList<>();
		

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


		public void setSalario(double salario) {
			this.salario = BigDecimal.valueOf(salario);
		}

		public void setSalario(BigDecimal salario) {
			this.salario = salario;
		}
		

}
