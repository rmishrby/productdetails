package com.publicis.sapient.p2p.repository;

import com.publicis.sapient.p2p.entity.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<Item,String> {

}
