package com.almacen.grupozara.AppZara.services.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.almacen.grupozara.AppZara.dto.BrandDTO;
import com.almacen.grupozara.AppZara.dto.ProductDTO;
import com.almacen.grupozara.AppZara.mapper.ProductMapper;
import com.almacen.grupozara.AppZara.models.Product;
import com.almacen.grupozara.AppZara.repository.ProductRepository;
import com.almacen.grupozara.AppZara.services.ProductService;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;

	
	
	@Autowired
	private ProductMapper productMapper;
	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public ProductDTO findByDate(ProductDTO productDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<ProductDTO> findById(Long product_Id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<BrandDTO> findByBrandId(Long brandId) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean deleteProduct(Long brandId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Product> findAllProduct() {
		
		TypedQuery<Product> query = entityManager.createQuery("SELECT p FROM Product p", Product.class);
	    return query.getResultList();
		
		
	}

	@Transactional
	public Product saveProduct(ProductDTO productDto) {
		
	 	  
		 entityManager.persist(productDto);
		 Product response = productMapper.dtoTOModel(productDto);
		 return response;
				
	}

	@Override
	public ProductDTO updateProduct(ProductDTO productDTO) {
		
		return entityManager.merge(productDTO);
	}

	

}
