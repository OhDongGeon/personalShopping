package org.personal.shopping.domain.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.personal.shopping.domain.category.domain.Category;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CategoryMapper {

    // 카테고리 조회
    List<Category> searchCategory();
}
