package com.almacen.grupozara.AppZara.mapper;

import com.almacen.grupozara.AppZara.dto.PriceDTO;
import com.almacen.grupozara.AppZara.models.Price;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface PriceMapper {
	
	
	@Mapping(source =  "priceId" , target = "price_Id" )
	@Mapping(source =  "productId" , target = "product_Id" )
	@Mapping(source = "brandId" , target = "brand_Id" )
	@Mapping(source = "starDate" , target = "starDate" )
	@Mapping(source = "endDate" , target = "endDate" )
	@Mapping(source = "priority" , target = "priority")
	@Mapping(source = "price" , target = "price_dto")
	@Mapping(source = "curr" , target = "curr" )
	@Mapping(source = "price_List" , target = "priceList_dto" )
    PriceDTO modelTODto(Price prices);

	
	@Mapping(source = "price_Id" , target = "priceId")
	@Mapping(source = "product_Id" , target = "productId")
	@Mapping(source = "brand_Id" , target = "brandId")
	@Mapping(source = "starDate" , target = "starDate")
	@Mapping(source = "endDate"  , target = "endDate")
	@Mapping(source = "priority" , target = "priority")
	@Mapping(source = "price_dto" , target = "price")
	@Mapping(source = "curr" , target = "curr")
	@Mapping(source = "priceList_dto" , target = "price_List")
	Price dtoToModel(PriceDTO pricesDTO);
    
      
    
}


