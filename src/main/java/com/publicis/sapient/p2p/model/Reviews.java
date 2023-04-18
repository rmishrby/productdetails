package com.publicis.sapient.p2p.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Reviews {

	private String productId;
	private double avgRating;
	private String totalReviews;

}
