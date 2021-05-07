package com.jubiter.logica;

import com.jubiter.modelo.AlmacenEmpresa;

public interface ManagerDeExistencias {
	
	AlmacenEmpresa buscarExistenciasAlmacenConcreto(int idProducto, int cantidad);

}
