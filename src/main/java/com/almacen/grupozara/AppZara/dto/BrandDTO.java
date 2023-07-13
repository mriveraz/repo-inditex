package com.almacen.grupozara.AppZara.dto;

import com.almacen.grupozara.AppZara.models.Product;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

import java.io.Serializable;
import java.util.Set;



@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BrandDTO implements Serializable {

    private static final long serialVersionUID = -2973959073428447618L;
    @JsonProperty("brand_Id")
    private Long brand_Id;
    @JsonProperty("productId")
    private Long productId;
    @JsonProperty("product")
    private Product product;
    @JsonProperty("product_List")
    private Set<Product> product_List;
    
   
    


}
