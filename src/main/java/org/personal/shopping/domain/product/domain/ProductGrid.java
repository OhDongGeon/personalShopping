package org.personal.shopping.domain.product.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductGrid {

    private Long productId;
    private String productName;
    private Long price;
    private String imageUrl;
}
