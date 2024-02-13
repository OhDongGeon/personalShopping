package org.personal.shopping.domain.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.personal.shopping.domain.review.model.dto.ReviewDetailDto;
import org.personal.shopping.domain.review.model.dto.ReviewSummaryDto;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ReviewMapper {

    // 리뷰 조회
    List<ReviewDetailDto> findReviewDetailByProductId(@Param("productId") Long productId,
                                                      @Param("offset") int offset,
                                                      @Param("pageSize") int pageSize);

    // 상품 아이디 기준 리뷰 수, 평점 조회
    ReviewSummaryDto findReviewSummaryByProductId(Long productId);
}
