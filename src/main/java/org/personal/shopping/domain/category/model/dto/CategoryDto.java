package org.personal.shopping.domain.category.model.dto;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.personal.shopping.domain.category.domain.Category;

@Getter
@Setter
@Builder
public class CategoryDto {

    private Long categoryId;
    private Long parentCategoryId;
    private String categoryName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String deleteFlag;
    private LocalDateTime deletedAt;

    public static CategoryDto from(Category category) {
        return CategoryDto.builder()
            .categoryId(category.getCategoryId())
            .parentCategoryId(category.getParentCategoryId())
            .categoryName(category.getCategoryName())
            .createdAt(category.getCreatedAt())
            .updatedAt(category.getCreatedAt())
            .deleteFlag(category.getDeleteFlag())
            .deletedAt(category.getDeletedAt())
            .build();
    }
}