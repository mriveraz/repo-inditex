package com.almacen.grupozara.AppZara.mapper;



import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.almacen.grupozara.AppZara.dto.ProductDTO;
import com.almacen.grupozara.AppZara.exceptions.ProductValidatorException;
import com.almacen.grupozara.AppZara.models.Product;
import com.almacen.grupozara.AppZara.validator.ProductValidator;




@Mapper(uses = {ProductValidator.class} , componentModel = "spring")
public interface ProductMapper {
	
	ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class); 
	
	@Mapping(source= "product_Id" , target = "product_Id")
	@Mapping(source = "brands" , target = "brands")
	@Mapping(source = "price_List" , target = "price_List")
    ProductDTO modelTODto(Product product) throws ProductValidatorException;
	
	
	List<ProductDTO> modelsToDtos(List<Product> product ) throws ProductValidatorException;
	
	//@Mapping(source = "product_Id" , target = "product_Id")
	@InheritInverseConfiguration
	Product dtoTOModel(ProductDTO productDTO) throws ProductValidatorException ;
   
  
}
