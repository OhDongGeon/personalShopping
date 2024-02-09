package org.personal.shopping.domain.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.personal.shopping.domain.product.domain.ProductDescription;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ProductDescriptionMapper {

    // 상품 아이디 기준 상세 설명 조회
    List<ProductDescription> findByProductId(Long productId);
}
