package org.personal.shopping.domain.category.model.dto;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.personal.shopping.domain.category.domain.CategoryBasic;

@Getter
@Setter
@Builder
public class CategoryTabDto {

    private CategoryBasic mainCategory;
    private List<CategoryBasic> subCategoryList;

    public static CategoryTabDto of(
        CategoryBasic mainCategory, List<CategoryBasic> subCategoryList) {

        return CategoryTabDto.builder()
            .mainCategory(mainCategory)
            .subCategoryList(subCategoryList)
            .build();
    }
}
