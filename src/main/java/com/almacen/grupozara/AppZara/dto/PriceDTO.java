package com.almacen.grupozara.AppZara.dto;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Id;


import com.almacen.grupozara.AppZara.models.Product;
import com.almacen.grupozara.AppZara.utility.Priority;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)


@JsonInclude(JsonInclude.Include.NON_NULL)
public class PriceDTO implements Serializable
{
    private static final long serialVersionUID = 4091776952626266465L;

    @JsonProperty("price_Id")
    private Long price_Id;
    @JsonProperty("product_Id")
    private Long product_Id;
    @JsonProperty("brand_Id")
    private Long brand_Id;
    @JsonProperty("starDate")
    private Date starDate;
    @JsonProperty("endDate")
    private Date endDate;
    @JsonProperty("price_dto")
    private BigDecimal price_dto;
    @JsonProperty("curr")
    private Double curr;
    @JsonProperty("priceList_dto")
    private Set<PriceDTO> priceList_dto;
    @JsonProperty("produc")
    private Product produc;
    @JsonProperty("priority")
    private Priority priority;
    
    
    


	 

}
