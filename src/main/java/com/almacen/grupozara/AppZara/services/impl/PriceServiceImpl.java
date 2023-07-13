package com.almacen.grupozara.AppZara.services.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.almacen.grupozara.AppZara.dto.PriceDTO;
import com.almacen.grupozara.AppZara.repository.PriceRepository;
import com.almacen.grupozara.AppZara.services.PriceService;
import com.almacen.grupozara.AppZara.utility.JPAUtility;

public class PriceServiceImpl implements PriceService {

	@Autowired
	private PriceRepository priceRepository;

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public PriceDTO savePrice(PriceDTO price) {

		try {

			
			EntityManager entityManager = JPAUtility.getEntityManager();
			
            		

			entityManager.getTransaction().begin();

			entityManager.persist(price);

			entityManager.getTransaction().commit();
			entityManager.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
		return price;

	}

	@Override
	public List<PriceDTO> findAllPrices() {

		return priceRepository.findAll();
	}

	@Override
	public Optional<PriceDTO> getPrices(Long productId) {
		return Optional.ofNullable(priceRepository.findById(productId).orElseThrow(() -> {
			throw new RuntimeException();
		}));

	}

	@Override
	@Transactional
	public PriceDTO updatePrices(Long productId, PriceDTO changePrice) {
		PriceDTO searchPrice = priceRepository.findById(productId).orElseThrow(null);
		/* Todo */
		// searchPrices.setPrice(changePrices.getPrices);
		PriceDTO response = priceRepository.save(searchPrice);
		return entityManager.merge(response);

	}

	@Override
	public boolean deletePrices(Long productId) {
		try {
			priceRepository.deleteById(productId);
			return true;
		} catch (Exception e) {
			return false;
		}

	}
}
