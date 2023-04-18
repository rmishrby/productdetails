package com.publicis.sapient.p2p.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.publicis.sapient.p2p.exception.BusinessException;
import com.publicis.sapient.p2p.exception.util.ErrorCode;
import com.publicis.sapient.p2p.exception.util.ErrorResolver;
import com.publicis.sapient.p2p.model.CatalogProduct;
import com.publicis.sapient.p2p.model.JsonMainObject;
import com.publicis.sapient.p2p.model.Product;
import com.publicis.sapient.p2p.entity.Item;
import com.publicis.sapient.p2p.entity.ProductDetails;
import com.publicis.sapient.p2p.repository.ItemRepository;
import com.publicis.sapient.p2p.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    private final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    ErrorResolver errorResolver;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ProductRepository productRepository;

    @Value("${catalogjson.file.path}")
    private String jsonFilePath;
    @Override
    public void  saveCatalogData() {
        logger.info("Entering saveCatalogData method inside ProductServiceImpl");
        ObjectMapper mapper = new ObjectMapper();
        List<CatalogProduct> catalogProducts = new ArrayList<>();
        try {
            JsonMainObject jsonMainObject = mapper.readValue(new File(jsonFilePath), JsonMainObject.class);
            catalogProducts = jsonMainObject.getCatalogProducts();
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
             logger.error(MessageFormat.format("error in saving data {0}", catalogProducts));
             throw new BusinessException(ErrorCode.BAD_REQUEST, errorResolver.getErrorMessage("ERR_SAVING_DATA", ""));
        }
    }

    @Override
    public Product getProductDetails(String productId) {
        logger.info("Entering getProductDetails method inside ProductServiceImpl");
        ProductDetails productDetails = productRepository.findById(productId)
                .orElseThrow(() -> {
                    logger.error(MessageFormat.format("product not found with id : {0}", productId));
                    return new BusinessException(ErrorCode.NOT_FOUND, errorResolver.getErrorMessage("ERR_DETAIL_NOT_FOUND", "product not found with id : " + productId));
                });

        List<Item> items = itemRepository.findAllById(productDetails.getItemsId());

        Product product = new Product();
        product.setProductDetails(productDetails);
        product.setItems(items);

        return product;

    }

}
