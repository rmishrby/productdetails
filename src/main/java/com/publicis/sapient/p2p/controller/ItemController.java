package com.publicis.sapient.p2p.controller;

import com.publicis.sapient.p2p.entity.Item;
import com.publicis.sapient.p2p.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ItemController {
    private final Logger logger = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    private ItemService itemService;

    @GetMapping(value = "/item")
    public List<Item> getItemDetails(@RequestParam String id){
        logger.info("Entering getItemDetails method with endpoint: /item");
        List<String> ids = Arrays.asList(id.split(","));
        List<Item> items = new ArrayList<>();
        ids.forEach(itemId -> items.add(itemService.getItemDetails(itemId)));
        return items;
    }
}