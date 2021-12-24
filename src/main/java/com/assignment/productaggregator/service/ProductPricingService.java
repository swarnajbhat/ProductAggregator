package com.assignment.productaggregator.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



import com.assignment.productaggregator.model.productpricing.ProductPricing;

@Service
public class ProductPricingService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${product.pricing.url}")
	String url;
	
	
	/*
	 * calls product pricing service to return the response
	 * @Param: id
	 * @Return : ProductPricingResponse object
	 */
	public ProductPricing getProductPricingInfo(String id){
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		
		ProductPricing response = restTemplate.getForObject(url, ProductPricing.class, params);
		
		return response;
		
	}
	
	public void updateProductPricingInfo(String id, ProductPricing pricingInfo) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		
		restTemplate.put(url, pricingInfo, params);
		
		
	}
}
