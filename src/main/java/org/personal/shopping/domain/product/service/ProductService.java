package org.personal.shopping.domain.product.service;

import java.util.List;
import java.util.Optional;
import org.personal.shopping.domain.mapper.ProductMapper;
import org.personal.shopping.domain.product.domain.ProductGrid;
import org.personal.shopping.global.util.PageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductMapper productMapper;


    // 페이지를 위한 총 상품 수
    public PageHandler totalProductByCategory(
        Long mainCategoryId, Optional<Long> subCategoryId, int page, int pageSize) {

        int totalCount = subCategoryId.map(subId -> productMapper.totalProductBySubCategory(subId))
            .orElseGet(() -> productMapper.totalProductByCategory(mainCategoryId));

        return new PageHandler(totalCount, page, pageSize);
    }

    // 상품 그리드 조회
    public List<ProductGrid> findProductByCategory(
        Long mainCategoryId, Optional<Long> subCategoryId, int page, int pageSize) {

        int offset = pageOffset(page, pageSize);

        return subCategoryId.map(subId -> productMapper.findProductBySubCategory(subId, offset, pageSize))
            .orElseGet(() -> productMapper.findProductByCategory(mainCategoryId, offset, pageSize));
    }

    // 페이지 offest 계산
    private int pageOffset(int page, int pageSize) {

        return Math.max((page - 1) * pageSize, 0);
    }
}
