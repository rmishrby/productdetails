package com.publicis.sapient.p2p.product.model;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(Include.NON_NULL)
public class ItemDetails {
	private String id;
	private String type;
	private String name;
	private Price prices[];
	private Inventories inventories[];
	private Attributes attributes[];
	private PromotionData promotions[];
	private ReviewsData reviewsAndRatings;
	//new props
	private List<Image> images;
	private Map<String, String> skuPrices;
	private String description;
	private String fulfillment; 
	private String foodType;

}
