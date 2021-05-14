package com.jubiter.exception;

/**
 * Es cierto que se deben conocer las clases que tiene Java para tratar los diferentes
 * tipos de excepciones; pero, a veces, puede ser de bastante ayuda personalizar 
 * mensajes para ser devueltos en el tránsito.
 * Por ejemplo, el mensaje que devuelve una llamada remota puede ayudar a detectar
 * el problema de manera más sencilla.
 * 
 * 
 * 
 * Este mensaje en concreto puede ser muy útil en la lógica de la aplicación, pues podría
 * indicar el almacén que no tiene cierto producto. Sirviendo de medida preventiva.
 * 
 * 
 * 
 * @author nr_alberto
 *
 */
public class CantidadDeProductoInsuficienteException extends RuntimeException{
	
	public CantidadDeProductoInsuficienteException(String mensaje) {
		super(mensaje);
	}

}
