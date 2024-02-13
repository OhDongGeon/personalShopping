package org.personal.shopping.domain.product.model.dto;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.personal.shopping.domain.product.domain.Product;
import org.personal.shopping.domain.product.domain.ProductDescription;
import org.personal.shopping.domain.product.domain.ProductImage;
import org.personal.shopping.domain.review.model.dto.ReviewSummaryDto;

@Getter
@Setter
@Builder
public class ProductDetailDto {

    private List<ProductImage> productImages;
    private Product product;
    private List<ProductColorDto> productColors;
    private List<ProductSizeDto> productSizes;
    private List<ProductDescription> productDescriptions;
    private ReviewSummaryDto reviewSummary;


    public static ProductDetailDto of(List<ProductImage> productImages, Product product,
        List<ProductColorDto> productColors, List<ProductSizeDto> productSizes,
        List<ProductDescription> productDescriptions, ReviewSummaryDto reviewSummary) {

        return ProductDetailDto.builder()
            .productImages(productImages)
            .product(product)
            .productColors(productColors)
            .productSizes(productSizes)
            .productDescriptions(productDescriptions)
            .reviewSummary(reviewSummary)
            .build();
    }
}
