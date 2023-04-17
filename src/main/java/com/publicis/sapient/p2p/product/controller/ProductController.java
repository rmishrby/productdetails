package com.publicis.sapient.p2p.product.controller;

import com.publicis.sapient.p2p.product.entity.ProductDetails;
import com.publicis.sapient.p2p.product.model.Product;
import com.publicis.sapient.p2p.product.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ProductController {
   @Autowired
   private ProductService productService;

   @GetMapping(value = "/product")
   public List<Product> getProductDetails(@RequestParam String id){
       List<String> ids = Arrays.asList(id.split(","));
       List<Product> products = new ArrayList<>();
       ids.forEach(productId -> products.add(productService.getProductDetails(productId)));
       return products;
    }

    @GetMapping(value = "/insert")
    public String insertProduct(){
        productService.saveCatalogData();
        return "{status : 'OK'}";
    }
}
