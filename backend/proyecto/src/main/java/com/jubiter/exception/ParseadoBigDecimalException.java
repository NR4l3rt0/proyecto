package com.jubiter.exception;

/**
 * Pone de manifiesto el hecho la complejidad que puede verse en los enlaces y castings.
 * 
 * Para más info: {@link con.jubiter.exception.CantidadDeProductoInsuficienteException}
 * 
 * @author nr_alberto
 *
 */
public class ParseadoBigDecimalException extends RuntimeException{

	public ParseadoBigDecimalException(String mensaje) {
		super(mensaje);
	}
}
