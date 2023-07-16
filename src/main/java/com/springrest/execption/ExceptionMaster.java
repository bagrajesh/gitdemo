package com.springrest.execption;

public class ExceptionMaster extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String msg;
	
	public ExceptionMaster(String msg) {
		super(msg);
	}

}
