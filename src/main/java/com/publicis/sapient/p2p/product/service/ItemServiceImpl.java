package com.publicis.sapient.p2p.product.service;

import com.publicis.sapient.p2p.product.entity.Item;
import com.publicis.sapient.p2p.product.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;
    @Override
    public Item getItem(String itemId) {
        return  itemRepository.findById(itemId).orElseThrow(()-> new RuntimeException("Item not found with id : "+itemId));

    }
}
