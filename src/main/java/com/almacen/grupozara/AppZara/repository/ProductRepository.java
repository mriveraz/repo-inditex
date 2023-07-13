package com.almacen.grupozara.AppZara.repository;

import com.almacen.grupozara.AppZara.dto.ProductDTO;
import com.almacen.grupozara.AppZara.models.Product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	Optional<Product> findById(Long id);
	
	Optional<Product> findByDate();
 
	List<ProductDTO> findAll(ProductDTO productDTO);
}
