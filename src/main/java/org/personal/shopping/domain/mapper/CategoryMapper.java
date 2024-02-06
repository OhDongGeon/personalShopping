package org.personal.shopping.domain.mapper;

import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;
import org.personal.shopping.domain.category.domain.CategoryBasic;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CategoryMapper {

    // 카테고리 전체 조회
    List<CategoryBasic> findByAllCategory();

    // 카테고리 아이디 기준 조회
    Optional<CategoryBasic> findByCategoryId(Long categoryId);

    // 하위 카테고리 조회
    List<CategoryBasic> findSubCategoryByCategoryId(Long categoryId);
}
