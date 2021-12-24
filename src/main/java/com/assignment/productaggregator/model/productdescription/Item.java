package com.assignment.productaggregator.model.productdescription;

import org.springframework.stereotype.Component;

@Component
public class Item {

	private ProductDescription productDescription;
	
	private Enrichment enrichment;
	
	private ProductClassification productClassification;
	
	private PrimaryBrand primaryBrand;

	public ProductDescription getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(ProductDescription productDescription) {
		this.productDescription = productDescription;
	}

	public Enrichment getEnrichment() {
		return enrichment;
	}

	public void setEnrichment(Enrichment enrichment) {
		this.enrichment = enrichment;
	}

	public ProductClassification getProductClassification() {
		return productClassification;
	}

	public void setProductClassification(ProductClassification productClassification) {
		this.productClassification = productClassification;
	}

	public PrimaryBrand getPrimaryBrand() {
		return primaryBrand;
	}

	public void setPrimaryBrand(PrimaryBrand primaryBrand) {
		this.primaryBrand = primaryBrand;
	}
	
	
}
