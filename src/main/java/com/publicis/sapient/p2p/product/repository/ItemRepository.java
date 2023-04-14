package com.publicis.sapient.p2p.product.repository;

import com.publicis.sapient.p2p.product.entity.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<Item,String> {

}
