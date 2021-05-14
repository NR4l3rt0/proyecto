package com.jubiter.exception;

/**
 * Muy útil cuando se pretende obtener un determinado producto pero se ha modificado, 
 * evitaría cambios incorrectos de manera temprana.
 * 
 * Para más info: {@link con.jubiter.exception.CantidadDeProductoInsuficienteException}
 * 
 * @author nr_alberto
 *
 */
public class IdNoEncontradoException extends RuntimeException {
	
		public IdNoEncontradoException(String mensajeError) {
			super(mensajeError);
		}
}
