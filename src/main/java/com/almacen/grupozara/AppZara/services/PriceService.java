package com.almacen.grupozara.AppZara.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.almacen.grupozara.AppZara.dto.PriceDTO;


@Service
public interface PriceService {

	PriceDTO savePrice(PriceDTO prices);

	List<PriceDTO> findAllPrices();

	Optional<PriceDTO> getPrices(Long productId);

	PriceDTO updatePrices(Long productId, PriceDTO changePrices);

	boolean deletePrices(Long productId);

}
