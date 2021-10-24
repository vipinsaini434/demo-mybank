package com.mycompany.wholesale.exception;

public class AccountNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountNotFoundException(Long id) {
		super("Could not find Account " + id);
	}

	public AccountNotFoundException() {
		super("Could not find Account ");
	}
}