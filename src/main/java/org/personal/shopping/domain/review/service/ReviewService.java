package org.personal.shopping.domain.review.service;

import java.util.List;
import org.personal.shopping.domain.mapper.ReviewMapper;
import org.personal.shopping.domain.review.model.dto.ReviewDetailDto;
import org.personal.shopping.domain.review.model.dto.ReviewSummaryDto;
import org.personal.shopping.global.util.PageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewMapper reviewMapper;


    // 리뷰 조회
    public List<ReviewDetailDto> getReview(Long productId, int page, int pageSize) {

        int offset = PageHandler.pageOffset(page, pageSize);

        // 리뷰 조회
        return reviewMapper.findReviewDetailByProductId(productId, offset, pageSize);
    }

    // 페이지를 위한 총 리뷰 수
    public PageHandler getReviewSummary(Long productId, int page, int pageSize) {

        // 상품 아이디 기준 리뷰 수, 평점 조회
        ReviewSummaryDto reviewSummary = reviewMapper.findReviewSummaryByProductId(productId);

        return new PageHandler(reviewSummary.getReviewCount().intValue(), page, pageSize);
    }
}
