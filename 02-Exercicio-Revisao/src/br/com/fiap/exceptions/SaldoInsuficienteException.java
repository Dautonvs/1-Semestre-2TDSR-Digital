package br.com.fiap.exceptions;

public class SaldoInsuficienteException extends Exception {

	public SaldoInsuficienteException() {
		super();
	}

	public SaldoInsuficienteException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public SaldoInsuficienteException(String message, Throwable cause) {
		super(message, cause);
	}

	public SaldoInsuficienteException(String message) {
		super(message);
	}

	public SaldoInsuficienteException(Throwable cause) {
		super(cause);
	}

	
	
}