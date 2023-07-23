package com.almacen.grupozara.AppZara.models;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product  implements Serializable {

    private static final long serialVersionUID = -2850147870395175027L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID")
    private Long product_Id;
    
    @OneToMany(mappedBy = "product" , cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    final private Set<Brand> brands = new HashSet<>();

    @ManyToMany(mappedBy = "produc" , cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    final private Set<Price> price_List = new HashSet<>();
    
  
	

   



}
