package org.personal.shopping.domain.category.service;

import java.util.List;
import java.util.stream.Collectors;
import org.personal.shopping.domain.category.domain.Category;
import org.personal.shopping.domain.category.model.dto.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    CategoryServiceImpl categoryServiceImpl;

    public List<CategoryDto> searchCategory() {

        List<Category> categories = categoryServiceImpl.searchCategory();

        return categories.stream().map(CategoryDto::from).collect(Collectors.toList());
    }
}
