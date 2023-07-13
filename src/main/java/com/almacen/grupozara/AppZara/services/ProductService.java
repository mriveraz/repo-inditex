package com.almacen.grupozara.AppZara.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.almacen.grupozara.AppZara.dto.BrandDTO;
import com.almacen.grupozara.AppZara.dto.ProductDTO;
import com.almacen.grupozara.AppZara.models.Product;


@Service
public interface ProductService {

  	
  public ProductDTO findByDate(ProductDTO productDto);
  public Optional<ProductDTO> findById(Long product_Id);
  public Optional<BrandDTO> findByBrandId(Long brandId);
  public boolean deleteProduct(Long brandId);
  public ProductDTO updateProduct(ProductDTO productDTO);
  public List<Product> findAllProduct();
  public Product saveProduct(ProductDTO productDTO);

 
  
  
  
		
}
