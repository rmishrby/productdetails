package com.publicis.sapient.p2p.product.repository;

import com.publicis.sapient.p2p.product.entity.ProductDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<ProductDetails,String> {
}
