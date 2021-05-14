package com.jubiter.modelo;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * Establece una unión entre almacén y empresa por motivos de simplicidad. Pues en un 
 * primer momento sólo se plantea tener un almacén centralizado; pero, podría darse el caso 
 * de que existan múltiples almacenes. O que cada almacén tenga su propio proveedor, etc...
 * Por tanto, dependerá también del transcurso lógico del plan de acción empresarial.
 * 
 * @author nr_alberto
 *
 */
@Entity
@Table(name = "almacen_empresa")
public class AlmacenEmpresa {

		@Id
		@SequenceGenerator(
				name = "secuencia_almacen_empresa",		 						 
				sequenceName = "secuencia_almacen_empresa", 						  
				allocationSize = 1 )
		@GeneratedValue( 
				strategy = GenerationType.SEQUENCE,	 						  
				generator = "secuencia_almacen_empresa"	)
		@JoinColumn(name = "pk_id_almacen_empresa")
		private Integer idAlmacenEmpresa;
		
		
		@Column(name = "nombre_empresa")
		private String nombreEmpresa;
		

		@OneToMany(mappedBy = "almacenEmpresa")
		private Set<ClienteProductoAlmacenEmpresa> clienteProductoAlmacenEmpresa;
		
		
		public AlmacenEmpresa() {
			super();
		}


		
		
		public AlmacenEmpresa(Integer idAlmacenEmpresa) {
			super();
			this.idAlmacenEmpresa = idAlmacenEmpresa;
		}




		public AlmacenEmpresa(String nombreEmpresa) {
			super();
			this.nombreEmpresa = nombreEmpresa;
		}
		
		
		public AlmacenEmpresa(Integer idAlmacenEmpresa, String nombreEmpresa) {
			super();
			this.idAlmacenEmpresa = idAlmacenEmpresa;
			this.nombreEmpresa = nombreEmpresa;
		}
		
		
		public AlmacenEmpresa(Integer idAlmacenEmpresa, String nombreEmpresa,
				Set<ClienteProductoAlmacenEmpresa> clienteProductoAlmacenEmpresa) {
			super();
			this.idAlmacenEmpresa = idAlmacenEmpresa;
			this.nombreEmpresa = nombreEmpresa;
			this.clienteProductoAlmacenEmpresa = clienteProductoAlmacenEmpresa;
		}


		public Integer getIdAlmacenEmpresa() {
			return idAlmacenEmpresa;
		}


		public void setIdAlmacenEmpresa(Integer idAlmacenEmpresa) {
			this.idAlmacenEmpresa = idAlmacenEmpresa;
		}


		public String getNombreEmpresa() {
			return nombreEmpresa;
		}


		public void setNombreEmpresa(String nombreEmpresa) {
			this.nombreEmpresa = nombreEmpresa;
		}


		public Set<ClienteProductoAlmacenEmpresa> getClienteProductoAlmacenEmpresa() {
			return clienteProductoAlmacenEmpresa;
		}


		public void setClienteProductoAlmacenEmpresa(Set<ClienteProductoAlmacenEmpresa> clienteProductoAlmacenEmpresa) {
			this.clienteProductoAlmacenEmpresa = clienteProductoAlmacenEmpresa;
		}


		@Override
		public String toString() {
			return "AlmacenEmpresa [idAlmacenEmpresa=" + idAlmacenEmpresa + ", nombreEmpresa=" + nombreEmpresa
					+ ", clienteProductoAlmacenEmpresa=" + clienteProductoAlmacenEmpresa + "]";
		}


		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((idAlmacenEmpresa == null) ? 0 : idAlmacenEmpresa.hashCode());
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
			AlmacenEmpresa other = (AlmacenEmpresa) obj;
			if (idAlmacenEmpresa == null) {
				if (other.idAlmacenEmpresa != null)
					return false;
			} else if (!idAlmacenEmpresa.equals(other.idAlmacenEmpresa))
				return false;
			return true;
		}
		

		
		
}
