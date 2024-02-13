package org.personal.shopping.domain.review.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewSummaryDto {

    private Long reviewCount;
    private Double ratingAvg;
}
