package com.publicis.sapient.p2p.product.controller;

import com.publicis.sapient.p2p.product.entity.Item;
import com.publicis.sapient.p2p.product.model.Product;
import com.publicis.sapient.p2p.product.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping(value = "/item")
    public List<Item> getItemDetails(@RequestParam String id){
        List<String> ids = Arrays.asList(id.split(","));
        List<Item> items = new ArrayList<>();
        ids.forEach(itemId -> items.add(itemService.getItem(itemId)));
        return items;
    }
}
