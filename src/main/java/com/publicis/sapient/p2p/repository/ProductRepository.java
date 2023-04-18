package com.publicis.sapient.p2p.repository;

import com.publicis.sapient.p2p.entity.ProductDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<ProductDetails,String> {
}
