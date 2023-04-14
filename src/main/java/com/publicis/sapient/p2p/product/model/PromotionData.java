package com.publicis.sapient.p2p.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PromotionData {
	private String promotionId;
	private String promotionDescription;
	private String promotionType;
	private Integer promotionValue;
	
}
