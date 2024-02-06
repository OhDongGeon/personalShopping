package org.personal.shopping.domain.category.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryBasic {

    private Long categoryId;
    private Long parentCategoryId;
    private String categoryName;
}
