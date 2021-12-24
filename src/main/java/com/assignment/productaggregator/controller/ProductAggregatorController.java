package com.assignment.productaggregator.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.productaggregator.model.ProductAggregator;
import com.assignment.productaggregator.service.ProductAggregatorService;


@RestController
@RequestMapping("/api/v1")
public class ProductAggregatorController {

	@Autowired
	private ProductAggregatorService service;
	
	/*
	 * returns the aggregated response for the product by id. this aggregates the product details and product pricing information to return a single aggregated response
	 * @Param: id
	 * @Return: :ProductAggregator response
	 */
	@GetMapping("/products/{id}")
	public ProductAggregator getAggregatedProductDetailsById(@PathVariable String id){
		return service.getAggregatedResponse(id);
	}
	
	
	/*
	 * updates the pricing information that is read from the ProductAggregator object
	 * @Request Body: ProductAggregator
	 * @Param : id
	 * @Return: void
	 */
	@PutMapping("/products/{id}")
	public void updateProductPricingById(@Valid @RequestBody ProductAggregator productAggregator, @PathVariable String id) {
		service.updateProductPricingById(id, productAggregator);
	}
	
	
}
