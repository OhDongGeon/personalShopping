package org.personal.shopping.domain.review.model.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ReviewDetailDto {

    private Long reviewId;
    private Long consumerId;
    private String consumerName;
    private Long productId;
    private Long rating;
    private String reviewText;
    private String createdAt;
    private String optionSize;
    private String optionColor;

    public static ReviewDetailDto from(ReviewDetailDto reviewDetailDto) {

        return ReviewDetailDto.builder()
            .reviewId(reviewDetailDto.getReviewId())
            .consumerId(reviewDetailDto.getConsumerId())
            .consumerName(reviewDetailDto.getConsumerName())
            .productId(reviewDetailDto.getProductId())
            .rating(reviewDetailDto.getRating())
            .reviewText(reviewDetailDto.getReviewText())
            .createdAt(reviewDetailDto.getCreatedAt())
            .optionSize(reviewDetailDto.getOptionSize())
            .optionColor(reviewDetailDto.getOptionColor())
            .build();
    }
}
