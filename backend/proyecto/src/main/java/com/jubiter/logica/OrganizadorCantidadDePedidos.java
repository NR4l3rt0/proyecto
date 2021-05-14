package com.jubiter.logica;

/**
 * Unido con {@link com.jubiter.logica.ManagerDeExistencias} establecerá
 * orden con los productos en los almacenes y define una relación precisa
 * con los pedidos.
 * Ayudará a que no se pierdan pedidos y se automatice el proceso de pedido empresarial.
 * Es decir el que relaciona a la empresa con su proveedor.
 * 
 * @author nr_alberto
 *
 */
public interface OrganizadorCantidadDePedidos {

	void restarCantidadDeProducto(int idProducto, int cantidad);
}
