package com.almacen.grupozara.AppZara.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.almacen.grupozara.AppZara.models.Brand;


@Repository
public interface BrandRepository extends JpaRepository<Brand,Long> {
	
}
