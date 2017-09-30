package com.baalam.exceptions;

public class NegativeNumberException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public NegativeNumberException(){
		super();
	}
	
	public NegativeNumberException(String mensaje){
		super(mensaje);
	}
	
	public NegativeNumberException(String mensaje, Throwable causa){
		super(mensaje, causa);
	}
	
	public NegativeNumberException(Throwable causa){
		super(causa);
	}
}