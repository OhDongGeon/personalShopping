package org.personal.shopping.domain.category.service;

import static org.personal.shopping.global.exception.ErrorCode.NOT_FIND_CATEGORY;

import java.util.List;
import java.util.stream.Collectors;
import org.personal.shopping.domain.category.domain.CategoryBasic;
import org.personal.shopping.domain.category.model.dto.CategoryBasicDto;
import org.personal.shopping.domain.category.model.dto.CategoryTabDto;
import org.personal.shopping.domain.mapper.CategoryMapper;
import org.personal.shopping.global.exception.FindException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;


    // 카테고리 전체 조회
    public List<CategoryBasicDto> searchCategory() {

        List<CategoryBasic> categories = categoryMapper.findByAllCategory();

        return categories.stream().map(CategoryBasicDto::from).collect(Collectors.toList());
    }

    // 카테고리 탭 조회
    public CategoryTabDto findByCategoryTab(Long main) {

        // 카테고리 아이디 기준 조회
        CategoryBasic mainCategory = categoryMapper.findByCategoryId(main)
            .orElseThrow(() -> new FindException(NOT_FIND_CATEGORY));

        // 하위 카테고리 조회
        List<CategoryBasic> subCategoryList =
            categoryMapper.findSubCategoryByCategoryId(mainCategory.getCategoryId());

        return CategoryTabDto.of(mainCategory, subCategoryList);
    }
}
