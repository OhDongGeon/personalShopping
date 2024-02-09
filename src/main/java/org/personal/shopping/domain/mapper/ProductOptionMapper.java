package org.personal.shopping.domain.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.personal.shopping.domain.product.model.dto.ProductColorDto;
import org.personal.shopping.domain.product.model.dto.ProductSizeDto;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ProductOptionMapper {

    // 상품 아이디 기준 컬러 조회
    List<ProductColorDto> findColorByProductId(Long productId);

    // 상품 아이디 기준 사이즈 조회
    List<ProductSizeDto> findSizeByProductId(Long productId);
}
