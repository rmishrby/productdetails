package com.publicis.sapient.p2p.service;

import com.publicis.sapient.p2p.entity.Item;
import org.springframework.stereotype.Service;

@Service
public interface ItemService {

    Item getItemDetails(String itemId);
}
