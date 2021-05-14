package com.jubiter.logica;

import com.jubiter.modelo.AlmacenEmpresa;

/**
 * Su función es controlar las existencias en cada almacén. Particularmente interesante
 * cuando se quiera trabajar con sistemas distribuidos.
 * 
 * @author nr_alberto
 *
 */
public interface ManagerDeExistencias {
	
	AlmacenEmpresa buscarExistenciasAlmacenConcreto(int idProducto, int cantidad);

}
