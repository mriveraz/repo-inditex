package com.almacen.grupozara.AppZara.mapper;

import com.almacen.grupozara.AppZara.dto.BrandDTO;
import com.almacen.grupozara.AppZara.models.Brand;
import com.almacen.grupozara.AppZara.models.Product;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;



@Mapper(componentModel = "spring")
public interface BrandMapper {

    
	@Mapping(source = "brandId" , target = "brand_Id")
	@Mapping(source = "productId" , target = "productId")
	@Mapping(source = "product" , target =  "product")
	@Mapping(source = "productsList" , target = "product_List")
	BrandDTO modelTODto(Brand brand);
	
	@Mapping(source = "brand_Id" , target = "brandId")
	@Mapping(source = "productId" , target = "productId")
	@Mapping(source = "product" , target = "product")
	
	Brand dtoToModel(BrandDTO brandDto);
	
	
	
	
	
	
   
	
	
	
	
	    
    
    
    
}
