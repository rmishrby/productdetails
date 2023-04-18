package com.publicis.sapient.p2p.controller;

import com.publicis.sapient.p2p.model.Product;
import com.publicis.sapient.p2p.service.ProductService;
import com.publicis.sapient.p2p.vo.ServiceResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@Tag(name = "Product", description = "Product Service API for getting product details")
public class ProductController {

   private final Logger logger = LoggerFactory.getLogger(ProductController.class);

   @Autowired
   private ProductService productService;

    @Operation(operationId = "getProductDetails", description = "Return all the items falling under Respective Product ID with additional product details", summary = "This endpoint fetches  details of all the items  falling under particular product", tags = {"Product"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Product details Fetched Successfully", content = @Content(array=@ArraySchema( schema = @Schema(implementation = Product.class)))),
                    @ApiResponse(responseCode = "404", description = "Product Not Found", content = @Content(schema = @Schema(implementation = ServiceResponse.class))),
            })
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
