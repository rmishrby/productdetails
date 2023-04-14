package com.publicis.sapient.p2p.product.service;

import com.publicis.sapient.p2p.product.entity.ProductDetails;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    public void  saveCatalogData();

    ProductDetails getProductDetails(String productId);
}
