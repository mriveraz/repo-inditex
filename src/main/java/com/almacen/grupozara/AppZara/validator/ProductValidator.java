package com.almacen.grupozara.AppZara.validator;

import org.springframework.stereotype.Component;

import com.almacen.grupozara.AppZara.exceptions.ProductValidatorException;

@Component
public class ProductValidator {
	
	public int validate(int id) throws ProductValidatorException {
		
		if (id == -1) {
			
			throw new ProductValidatorException("Invalid id value"); 
		}
		
		return id;
	}

}
