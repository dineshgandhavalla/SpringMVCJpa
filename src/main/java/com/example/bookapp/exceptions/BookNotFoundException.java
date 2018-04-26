package com.example.bookapp.exceptions;

public class BookNotFoundException extends Exception {

	
	private static final long serialVersionUID = 1L;
	public BookNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}


	public BookNotFoundException(String s) {
		super(s);
	}
}
