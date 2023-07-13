package com.almacen.grupozara.AppZara.models;

import lombok.*;
import javax.persistence.*;

import com.almacen.grupozara.AppZara.utility.Priority;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "prices")
public class Price implements  Serializable{

    private static final long serialVersionUID = 3189573854350369988L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PRICE_ID")
    private Long priceId;
    @Column(name="PRODUCT_ID")
    private Long productId;
    @Column(name="BRAND_ID")
    @JsonFormat(pattern = "MM/dd/yyyy")
    private Long brandId;
    @Column(name="START_DATE", nullable = false)
    @JsonFormat(pattern = "MM/dd/yyyy")
    private Date starDate;
    @Column(name="END_DATE", nullable = false)
    private Date endDate;
    @Column(name="PRIORITY")
    @Enumerated(EnumType.ORDINAL)
    private Priority priority;
    @Column(name="PRICE")
    private BigDecimal price;
    @Column(name="CURR")
    private String curr;
    @Column(name = "PRICE_LIST")
    Set<Price> price_List = new HashSet<>();

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(name = "PRICE_PRODUCT_TBL",
    joinColumns = {@JoinColumn(name = "PRICE_ID")},
    inverseJoinColumns = { @JoinColumn(name = "PRODUCT_ID" ) })
    Product produc;
   
	@Override
	public int hashCode() {
		return Objects.hash(brandId, curr, endDate, price, priceId, price_List, priority, produc, productId, starDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Price other = (Price) obj;
		return Objects.equals(brandId, other.brandId) && Objects.equals(curr, other.curr)
				&& Objects.equals(endDate, other.endDate) && Objects.equals(price, other.price)
				&& Objects.equals(priceId, other.priceId) && Objects.equals(price_List, other.price_List)
				&& Objects.equals(priority, other.priority) && Objects.equals(produc, other.produc)
				&& Objects.equals(productId, other.productId) && Objects.equals(starDate, other.starDate);
	}

    
}
