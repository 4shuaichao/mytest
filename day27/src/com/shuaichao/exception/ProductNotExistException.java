package com.shuaichao.exception;

@SuppressWarnings("serial")
public class ProductNotExistException extends Exception {

	public ProductNotExistException() {
		super();
	}

	public ProductNotExistException(String message) {
		super(message);
	}

}
