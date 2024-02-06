package org.personal.shopping.domain.category.interceptor;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.personal.shopping.domain.category.model.dto.CategoryBasicDto;
import org.personal.shopping.domain.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class CategoryInterceptor implements HandlerInterceptor {

    @Autowired
    private CategoryService categoryService;


    // 메인 헤더 카테고리 조회
    @Override
    public boolean preHandle(
        HttpServletRequest request, HttpServletResponse response, Object handler) {

        List<CategoryBasicDto> categoryList = categoryService.searchCategory();
        request.setAttribute("categoryList", categoryList);

        return true;
    }
}
