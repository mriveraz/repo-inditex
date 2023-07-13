package com.almacen.grupozara.AppZara.repository;

import com.almacen.grupozara.AppZara.dto.PriceDTO;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<PriceDTO,Long> {
	
	
	Optional<PriceDTO> findById(Long id);

}
