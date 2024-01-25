package org.personal.shopping.domain.category.interceptor;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.personal.shopping.domain.category.model.dto.CategoryDto;
import org.personal.shopping.domain.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class CategoryInterceptor implements HandlerInterceptor {

    @Autowired
    private CategoryService categoryService;

    @Override
    public boolean preHandle(
        HttpServletRequest request, HttpServletResponse response, Object handler) {

        List<CategoryDto> categoryList = categoryService.searchCategory();
        request.setAttribute("categoryList", categoryList);

        return true;
    }
}
