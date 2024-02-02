package org.personal.shopping.domain.category.service;

import java.util.List;
import java.util.stream.Collectors;
import org.personal.shopping.domain.category.domain.Category;
import org.personal.shopping.domain.category.model.dto.CategoryDto;
import org.personal.shopping.domain.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;


    public List<CategoryDto> searchCategory() {

        List<Category> categories = categoryMapper.searchCategory();

        return categories.stream().map(CategoryDto::from).collect(Collectors.toList());
    }
}
