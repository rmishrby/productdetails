package com.publicis.sapient.p2p.controller;

import com.publicis.sapient.p2p.model.Product;
import com.publicis.sapient.p2p.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ProductController {

   private final Logger logger = LoggerFactory.getLogger(ProductController.class);

   @Autowired
   private ProductService productService;

   @GetMapping(value = "/product")
   public List<Product> getProductDetails(@RequestParam String id){
       logger.info("Entering getProductDetails method with endpoint: /product");
       List<String> ids = Arrays.asList(id.split(","));
       List<Product> products = new ArrayList<>();
       ids.forEach(productId -> products.add(productService.getProductDetails(productId)));
       return products;
    }

    @GetMapping(value = "/insert")
    public String insertProduct(){
        logger.info("Entering insertProduct method with endpoint: /insert");
        productService.saveCatalogData();
        return "{status : 'OK'}";
    }
}
