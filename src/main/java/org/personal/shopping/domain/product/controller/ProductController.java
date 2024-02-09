package org.personal.shopping.domain.product.controller;

import java.util.List;
import java.util.Optional;
import org.personal.shopping.domain.category.model.dto.CategoryTabDto;
import org.personal.shopping.domain.category.service.CategoryService;
import org.personal.shopping.domain.product.domain.ProductGrid;
import org.personal.shopping.domain.product.model.dto.ProductDetailDto;
import org.personal.shopping.domain.product.service.ProductService;
import org.personal.shopping.global.util.PageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;


    // 카테고리 기준 상품 그리드 조회
    @GetMapping()
    public String findProductByCategory(Model model, @RequestParam("main") Long main,
        @RequestParam(value = "sub", required = false) Long sub,
        @RequestParam(value = "page", defaultValue = "1") int page,
        @RequestParam(value = "pageSize", defaultValue = "15") int pageSize) {

        // 카테고리 탭 조회
        CategoryTabDto byCategoryProduct = categoryService.findByCategoryTab(main);

        // 상품 그리드 조회
        List<ProductGrid> productGrids =
            productService.findProductByCategory(main, Optional.ofNullable(sub), page, pageSize);

        // 페이지를 위한 총 상품 수
        PageHandler pageHandler =
            productService.totalProductByCategory(main, Optional.ofNullable(sub), page, pageSize);

        model.addAttribute("categoryProduct", byCategoryProduct);
        model.addAttribute("productGrid", productGrids);
        model.addAttribute("pageHandler", pageHandler);

        return "product";
    }

    // 상품 정보 조회
    @GetMapping("/{productId}/categories/{categoryId}")
    public String getProductDetail(Model model, @PathVariable("productId") Long productId,
        @PathVariable("categoryId") String categoryId) {

        // 상품 조회
        ProductDetailDto productDetail = productService.getProductDetail(productId);

        model.addAttribute("productDetail", productDetail);

        return "productDetail";
    }
}
