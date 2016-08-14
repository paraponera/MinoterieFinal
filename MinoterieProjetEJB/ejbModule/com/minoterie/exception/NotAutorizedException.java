package com.minoterie.exception;

public class NotAutorizedException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotAutorizedException() {
		super("non_autoriser");
	}

}
