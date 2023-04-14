package com.publicis.sapient.p2p.product.entity;

import com.publicis.sapient.p2p.product.model.Attributes;
import com.publicis.sapient.p2p.product.model.Category;
import com.publicis.sapient.p2p.product.model.Image;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "product_details")
public class ProductDetails {

    @Id
    private String id;
    private String name;
    private String type;
    private String description;
    private List<String> itemsId;
    private Category category;
    private List<Image> images;
    private List<Attributes> attributes;
    private String brand;
}
