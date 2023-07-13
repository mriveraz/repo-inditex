package com.almacen.grupozara.AppZara.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Id;

import com.almacen.grupozara.AppZara.models.Brand;
import com.almacen.grupozara.AppZara.models.Price;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDTO implements Serializable {

    private static final long serialVersionUID = -3739853829643124969L;

    	
    @JsonProperty("product_Id")
    private Long product_Id;
    @JsonProperty("brands")
    private Set<Brand> brands;
    @JsonProperty("price_List")
    private Set<Price> price_List;
    

}
