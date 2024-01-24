package org.personal.shopping.domain.category.domain;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category {

    private Long categoryId;
    private Long parentCategoryId;
    private String categoryName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String deleteFlag;
    private LocalDateTime deletedAt;
}