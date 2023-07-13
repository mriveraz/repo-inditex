package com.almacen.grupozara.AppZara.exceptions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.almacen.grupozara.AppZara.models.Price;
import com.almacen.grupozara.AppZara.models.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppZaraException extends Exception {
	
	private static final long serialVersionUID = -3796857332586338355L;

	private  String code;

	private  int responseCode;

	private final List<ErrorDto> errorList = new ArrayList<>();

	public AppZaraException(String code, int responseCode, String message) {
		super(message);
		this.code = code;
		this.responseCode = responseCode;
	}

	public AppZaraException(String code, int responseCode, String message, List<ErrorDto> errorList) {
		super(message);
		this.code = code;
		this.responseCode = responseCode;
		this.errorList.addAll(errorList);
	}

}
