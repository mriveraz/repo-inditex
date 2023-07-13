package com.almacen.grupozara.AppZara.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.almacen.grupozara.AppZara.dto.PriceDTO;
import com.almacen.grupozara.AppZara.mapper.PriceMapper;
import com.almacen.grupozara.AppZara.services.PriceService;

@RestController
@RequestMapping( value = "/prices" )
public class PriceController {

	@Autowired
	private PriceService priceService;

	@Autowired
	private PriceMapper priceMapper;

	@PostMapping("/save" )
	public ResponseEntity<PriceDTO> savePricesWithProducts(@RequestBody PriceDTO prices) {
		return new ResponseEntity<>(priceService.savePrice(prices), HttpStatus.CREATED);
	}

	@GetMapping("/prices/{id}")
	public ResponseEntity<PriceDTO> getPrices(@PathVariable("id") Long productId) {
		Optional<PriceDTO> optionalPrices = priceService.getPrices(productId);
		return optionalPrices.map(ResponseEntity::ok).orElseThrow();
	}

	@PutMapping("/{id}")
	public ResponseEntity<PriceDTO> updatePrices(@PathVariable("id") Long productId,
			@RequestBody PriceDTO changePrices) {
		return new ResponseEntity<>(priceService.updatePrices(productId, changePrices), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<PriceDTO> deletePrices(@PathVariable("id") Long productId) {

		boolean result = priceService.deletePrices(productId);
		if (result) {

			return new ResponseEntity<>(HttpStatus.OK);

		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
	}

}
