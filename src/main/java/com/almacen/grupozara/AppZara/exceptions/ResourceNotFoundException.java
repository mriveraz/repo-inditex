package com.almacen.grupozara.AppZara.exceptions;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;

import org.springframework.http.HttpStatus;

import com.almacen.grupozara.AppZara.models.Price;
import com.almacen.grupozara.AppZara.models.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@NoArgsConstructor
public class ResourceNotFoundException extends AppZaraException {
    
	private static final long serialVersionUID = -2982837913962864449L;
    
    
    
    public  ResourceNotFoundException(String code, String message) {
		super(code,HttpStatus.NOT_FOUND.value(),message);
	}

	public ResourceNotFoundException(String code, String message, ErrorDto data) {
		super(code,HttpStatus.NOT_FOUND.value(),message, Arrays.asList(data));
	}


   
}
