package org.personal.shopping.domain.product.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

    private Long productId;
    private String productName;
    private Long price;
}
