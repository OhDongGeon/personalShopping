package org.personal.shopping.domain.product.service;

import java.util.List;
import java.util.Optional;
import org.personal.shopping.domain.mapper.ProductDescriptionMapper;
import org.personal.shopping.domain.mapper.ProductImageMapper;
import org.personal.shopping.domain.mapper.ProductMapper;
import org.personal.shopping.domain.mapper.ProductOptionMapper;
import org.personal.shopping.domain.mapper.ReviewMapper;
import org.personal.shopping.domain.product.domain.Product;
import org.personal.shopping.domain.product.domain.ProductDescription;
import org.personal.shopping.domain.product.domain.ProductGrid;
import org.personal.shopping.domain.product.domain.ProductImage;
import org.personal.shopping.domain.product.model.dto.ProductColorDto;
import org.personal.shopping.domain.product.model.dto.ProductDetailDto;
import org.personal.shopping.domain.product.model.dto.ProductSizeDto;
import org.personal.shopping.domain.review.model.dto.ReviewSummaryDto;
import org.personal.shopping.global.util.PageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductImageMapper productImageMapper;

    @Autowired
    private ProductOptionMapper productOptionMapper;

    @Autowired
    private ProductDescriptionMapper productDescriptionMapper;

    @Autowired
    private ReviewMapper reviewMapper;


    // 페이지를 위한 총 상품 수
    public PageHandler totalProductByCategory(
        Long mainCategoryId, Optional<Long> subCategoryId, int page, int pageSize) {

        int totalCount = subCategoryId.map(subId -> productMapper.totalProductBySubCategory(subId))
            .orElseGet(() -> productMapper.totalProductByCategory(mainCategoryId));

        return new PageHandler(totalCount, page, pageSize);
    }

    // 상품 그리드 조회
    public List<ProductGrid> findProductByCategory(
        Long mainCategoryId, Optional<Long> subCategoryId, int page, int pageSize) {

        int offset = PageHandler.pageOffset(page, pageSize);

        return subCategoryId.map(subId -> productMapper.findProductBySubCategory(subId, offset, pageSize))
            .orElseGet(() -> productMapper.findProductByCategory(mainCategoryId, offset, pageSize));
    }

    // 상품 정보 조회
    public ProductDetailDto getProductDetail(Long productId) {

        // 상품 아이디 기준 이미지 조회
        List<ProductImage> productImages = productImageMapper.findByProductId(productId);

        // 상품 아이디 기준 정보 조회
        Product product = productMapper.findByProductId(productId);

        // 상품 아이디 기준 컬러 조회
        List<ProductColorDto> productColors = productOptionMapper.findColorByProductId(productId);

        // 상품 아이디 기준 사이즈 조회
        List<ProductSizeDto> productSizes = productOptionMapper.findSizeByProductId(productId);

        // 상품 아이디 기준 상세 설명 조회
        List<ProductDescription> productDescriptions =
            productDescriptionMapper.findByProductId(productId);

        // 상품 아이디 기준 리뷰 수, 평점 조회
        ReviewSummaryDto reviewSummary = reviewMapper.findReviewSummaryByProductId(productId);

        return ProductDetailDto.of(
            productImages, product, productColors, productSizes, productDescriptions, reviewSummary);
    }
}
