package com.publicis.sapient.p2p.product.entity;


import com.publicis.sapient.p2p.product.model.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "item_details")
public class Item {

    @Id
    private String id;
    private String type;
    private String name;
    private String description;
    private String origin;
    private String fulfillment;
    private List<Price> prices;
    private List<Inventories> inventories;
    private List<Image> images;
    private List<Attributes> attributes;
}
