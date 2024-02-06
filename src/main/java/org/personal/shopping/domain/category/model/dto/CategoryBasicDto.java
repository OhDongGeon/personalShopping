package org.personal.shopping.domain.category.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.personal.shopping.domain.category.domain.CategoryBasic;

@Getter
@Setter
@Builder
public class CategoryBasicDto {

    private Long categoryId;
    private String categoryName;
    private Long parentCategoryId;

    public static CategoryBasicDto from(CategoryBasic category) {
        return CategoryBasicDto.builder()
            .categoryId(category.getCategoryId())
            .categoryName(category.getCategoryName())
            .parentCategoryId(category.getParentCategoryId())
            .build();
    }
}
