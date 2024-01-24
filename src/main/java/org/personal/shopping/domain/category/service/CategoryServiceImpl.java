package org.personal.shopping.domain.category.service;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.personal.shopping.domain.category.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryServiceImpl {

    @Autowired
    private SqlSession session;

    private static final String nameSpace = "org.personal.shopping.mapper.CategoryMapper.";

    public List<Category> searchCategory() {

        return session.selectList(nameSpace + "categorySelect");
    }
}
