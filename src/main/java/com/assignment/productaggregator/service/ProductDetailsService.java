package com.assignment.productaggregator.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.assignment.productaggregator.model.productdescription.Product;



@Service
public class ProductDetailsService {
	
	/*private WebClient client = WebClient.builder()
			.baseUrl("http://localhost:5010/productdetails")
			.build();
	
	public ResponseEntity<Product> getProductDetailsById(String id){
		return this.client.get()
				.uri("/api/v1/productdetails/{id}",id)
				.retrieve()
				.toEntity(Product.class)
				.block();
	}
	*/
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${product.details.url}")
	String url;
	
	/*
	 * calls product details service to return the response
	 * @Param: id
	 * @Return : Product object
	 */
	public Product getProductDetailsById(String id){
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		
		Product returnedProduct = restTemplate.getForObject(url, Product.class, params);
		
		return returnedProduct;
	}
}
