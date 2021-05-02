package com.jubiter.Excepcion;

public class IdNoEncontradoException extends RuntimeException {
	
		public IdNoEncontradoException(String mensajeError) {
			super(mensajeError);
		}
}
