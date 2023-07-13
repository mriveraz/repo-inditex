package com.almacen.grupozara.AppZara.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.almacen.grupozara.AppZara.dto.ProductDTO;
import com.almacen.grupozara.AppZara.mapper.ProductMapper;
import com.almacen.grupozara.AppZara.models.Product;
import com.almacen.grupozara.AppZara.repository.ProductRepository;
import com.almacen.grupozara.AppZara.services.ProductService;
import com.almacen.grupozara.AppZara.services.impl.ProductServiceImpl;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {
	
	@Autowired
	private ProductMapper productMapper;
	
	@Autowired
	private ProductService productService;
	
	public ResponseEntity<Product> save(@RequestBody Product product){
		
		
		return new ResponseEntity<>(productService.saveProduct(productMapper.modelTODto(product)), HttpStatus.CREATED) ;
		
	}
	
	
	
	
	

}
