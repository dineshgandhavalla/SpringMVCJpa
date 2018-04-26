package com.example.bookapp.exceptions;

public class CategoryNotFoundException  extends Exception{

	/*public CategoryNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoryNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
*/
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CategoryNotFoundException(String s) {
		super(s);
	}

}
