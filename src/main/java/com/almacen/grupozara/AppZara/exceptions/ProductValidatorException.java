package com.almacen.grupozara.AppZara.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProductValidatorException extends RuntimeException {

	private static final long serialVersionUID = 1276206812019386604L;

	public ProductValidatorException(String massage) {
		super(massage);
		
	}


	
	
	
	

}
