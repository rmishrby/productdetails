package com.publicis.sapient.p2p.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JsonMainObject {
    List<CatalogProduct> catalogProducts;
}
