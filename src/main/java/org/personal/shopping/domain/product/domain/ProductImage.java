package org.personal.shopping.domain.product.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductImage {

    private Long productImageId;
    private String imageUrl;
    private String mainImageFlag;
}
