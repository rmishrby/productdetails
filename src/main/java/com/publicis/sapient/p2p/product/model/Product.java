package com.publicis.sapient.p2p.product.model;

import com.publicis.sapient.p2p.product.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
	
	private String id;
	private String name;
	private String type;
	private String description;
	private List<Item> items;
	private Category category;
	private List<Image> images;
	private List<Attributes> attributes;
	private String brand;

}
