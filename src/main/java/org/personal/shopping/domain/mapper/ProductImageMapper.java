package org.personal.shopping.domain.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.personal.shopping.domain.product.domain.ProductImage;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ProductImageMapper {

    // 상품 아이디 기준 이미지 조회
    List<ProductImage> findByProductId(Long productId);
}
