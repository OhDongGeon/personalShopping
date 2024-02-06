package org.personal.shopping.domain.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.personal.shopping.domain.product.domain.ProductGrid;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ProductMapper {

    // 상위 카테고리 기준 상품 총 수
    int totalProductByCategory(Long categoryId);

    // 하위 카테고리 기준 상품 총 수
    int totalProductBySubCategory(Long categoryId);

    // 상위 카테고리 기준 상품 조회
    List<ProductGrid> findProductByCategory(@Param("categoryId") Long categoryId,
                                            @Param("offset") int offset,
                                            @Param("pageSize") int pageSize);

    // 하위 카테고리 기준 상품 조회
    List<ProductGrid> findProductBySubCategory(@Param("categoryId") Long categoryId,
                                               @Param("offset") int offset,
                                               @Param("pageSize") int pageSize);
}
