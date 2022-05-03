package br.com.cliente.api.exceptions;

public class GenericException extends Exception {
	

	private static final long serialVersionUID = -7082212867266961646L;
	private final String customMessage;
	private Object ob;

	public GenericException(String msg) {
		this.customMessage = msg;
	}
	public GenericException(String msg, Object ob) {
		this.customMessage = msg;
		this.ob = ob;
	}

	public String getCustomMessage() {
		return customMessage;
	}

	
	
	
}
