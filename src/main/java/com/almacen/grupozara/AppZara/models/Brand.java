package com.almacen.grupozara.AppZara.models;


import lombok.*;



import java.io.Serializable;
import java.util.HashSet;

import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.persistence.JoinColumn;





@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Entity
@Table(name="brands")

public class Brand implements Serializable {

    private static final long serialVersionUID = -889537319213229887L;
    @Id
    @Column(name="BRAND_ID", nullable = false, updatable = false)
    private Long brandId;
    @Column(name="PRODUCT_ID", nullable = false)
    private Long productId;
    
    @ManyToOne
    @JoinColumn(name = "productId" , nullable = false)
    private Product product;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "BRAND_PRODUCT",
            joinColumns = @JoinColumn(name = "BRAND_ID", referencedColumnName = "brandId",nullable = false, updatable = false),
            inverseJoinColumns = @JoinColumn (name= "PRODUCT_ID", referencedColumnName = "productId",nullable = false, updatable = false))
    final private Set<Product> productsList = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brand brand = (Brand) o;
        return brandId.equals(brand.brandId) && productId.equals(brand.productId) && productsList.equals(brand.productsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brandId, productId, productsList);
    }
}
