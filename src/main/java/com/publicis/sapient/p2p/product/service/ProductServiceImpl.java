package com.publicis.sapient.p2p.product.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.publicis.sapient.p2p.product.entity.Item;
import com.publicis.sapient.p2p.product.entity.ProductDetails;
import com.publicis.sapient.p2p.product.model.CatalogProduct;
import com.publicis.sapient.p2p.product.model.JsonMainObject;
import com.publicis.sapient.p2p.product.model.Product;
import com.publicis.sapient.p2p.product.repository.ItemRepository;
import com.publicis.sapient.p2p.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ProductRepository productRepository;

    @Value("${catalogjson.file.path}")
    private String jsonFilePath;
    @Override
    public void  saveCatalogData() {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println("inside save data ");
        try {
            JsonMainObject jsonMainObject = mapper.readValue(new File(jsonFilePath), JsonMainObject.class);
            List<CatalogProduct> catalogProducts = jsonMainObject.getCatalogProducts();
            for(CatalogProduct catalogProduct : catalogProducts) {
                Product product = catalogProduct.getProduct();
                List<Item> items = product.getItems();
                itemRepository.saveAll(items);
                ProductDetails productDetail = new ProductDetails();
                productDetail.setId(product.getId());
                productDetail.setBrand(product.getBrand());
                productDetail.setDescription(product.getDescription());
                productDetail.setImages(product.getImages());
                productDetail.setName(product.getName());
                productDetail.setType(product.getType());
                productDetail.setCategory(product.getCategory());
                List<String> itemId = new ArrayList<>();
                items.forEach(item -> itemId.add(item.getId()));
                productDetail.setItemsId(itemId);
                productRepository.save(productDetail);
            }
        }

         catch (IOException e) {
            // TODO Auto-generated catch block

            e.printStackTrace();
        }
    }

    @Override
    public ProductDetails getProductDetails(String productId) {
        return productRepository.findById(productId).orElseThrow(() -> new RuntimeException("product not found with id : " + productId));
    }

}
