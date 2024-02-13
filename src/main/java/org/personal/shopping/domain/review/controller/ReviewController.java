package org.personal.shopping.domain.review.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.personal.shopping.domain.review.model.dto.ReviewDetailDto;
import org.personal.shopping.domain.review.service.ReviewService;
import org.personal.shopping.global.util.PageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;


    // 리뷰 조회
    @GetMapping("/products/{productId}")
    public ResponseEntity<Map<String, Object>> getReview(@PathVariable("productId") Long productId,
        @RequestParam(value = "page", defaultValue = "1") int page,
        @RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {

        // 리뷰 조회
        List<ReviewDetailDto> reviewDetails = reviewService.getReview(productId, page, pageSize);

        // 페이지를 위한 총 리뷰 수
        PageHandler pageHandler = reviewService.getReviewSummary(productId, page, pageSize);

        Map<String, Object> response = new HashMap<>();
        response.put("reviewDetails", reviewDetails);
        response.put("pageHandler", pageHandler);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
