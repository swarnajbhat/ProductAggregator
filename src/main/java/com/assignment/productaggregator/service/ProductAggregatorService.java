package com.assignment.productaggregator.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.productaggregator.model.CurrentPrice;
import com.assignment.productaggregator.model.ProductAggregator;
import com.assignment.productaggregator.model.productdescription.Product;
import com.assignment.productaggregator.model.productpricing.ProductPricing;


@Service
public class ProductAggregatorService {

	@Autowired
	private ProductDetailsService productDetailsService;
	
	@Autowired
	private ProductPricingService productPricingService;
	
	public ProductAggregator getAggregatedResponse(String id) {
		
		 Product productDeatilsResponse =  productDetailsService.getProductDetailsById(id);
		 ProductPricing productPricingResponse = productPricingService.getProductPricingInfo(id);
		 ProductAggregator response = getCombinedResponse(productDeatilsResponse,productPricingResponse);
		 return response;
		 
	}
	
	

	private ProductAggregator getCombinedResponse(Product productDeatilsResponse,
			ProductPricing productPricingResponse) {
		
		
		CurrentPrice currentPrice = new CurrentPrice();
		currentPrice.setCurrencyCode(productPricingResponse.getCurrencyCode());
		currentPrice.setValue(productPricingResponse.getUnitPrice());
		
		ProductAggregator response = new ProductAggregator();
		response.setId(productDeatilsResponse.getTcin());
		response.setName(productDeatilsResponse.getItem().getProductDescription().getTitle());
		response.setCurrentPrice(currentPrice);
		
		return response;
	}



	public void updateProductPricingById(String id, ProductAggregator productAggregator) {
		
		ProductPricing pricingRequest = createProductPricingRequest(id,productAggregator);
		productPricingService.updateProductPricingInfo(id, pricingRequest);
		
	}



	private ProductPricing createProductPricingRequest(String id, @Valid ProductAggregator productAggregator) {
		ProductPricing request = new ProductPricing();
		request.setId(id);
		request.setUnitPrice(productAggregator.getCurrentPrice().getValue());
		request.setCurrencyCode(productAggregator.getCurrentPrice().getCurrencyCode());
		return request;
	}
}
