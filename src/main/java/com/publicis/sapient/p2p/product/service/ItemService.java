package com.publicis.sapient.p2p.product.service;

import com.publicis.sapient.p2p.product.entity.Item;
import org.springframework.stereotype.Service;

@Service
public interface ItemService {

    Item getItem(String itemId);
}
