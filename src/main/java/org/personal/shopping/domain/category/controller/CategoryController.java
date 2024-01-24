package org.personal.shopping.domain.category.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.personal.shopping.domain.category.model.dto.CategoryDto;
import org.personal.shopping.domain.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public String index(Model model) {

        List<CategoryDto> categoryList = categoryService.searchCategory();

        List<CategoryDto> collect = categoryList.stream()
            .filter(e -> e.getParentCategoryId() == null).collect(Collectors.toList());

        for (CategoryDto categoryDto : collect) {
            System.out.println(categoryDto.toString());
        }

        model.addAttribute("list", categoryList);

        return "index";
    }
}
