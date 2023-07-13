package com.almacen.grupozara.AppZara.exceptions;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class ErrorDto implements Serializable {

	private static final long serialVersionUID = 1464120871492304863L;
	
	private String name;

	private String value;



	public ErrorDto(String name, String value) {
		this.name = name;
		this.value = value;
	}
	

}
