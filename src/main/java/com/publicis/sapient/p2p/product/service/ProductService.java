package com.publicis.sapient.p2p.product.service;

import com.publicis.sapient.p2p.product.model.Product;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    public void  saveCatalogData();

    Product getProductDetails(String productId);
}
