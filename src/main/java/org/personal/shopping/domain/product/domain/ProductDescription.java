package org.personal.shopping.domain.product.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDescription {

    private Long productDescriptionId;
    private Long productId;
    private String contentsType;
    private String contentsValue;
    private Long sequence;
}
