package com.ann.spring_web_test.dao;

import com.ann.spring_web_test.model.Category;

import java.util.List;

/**
 * Created by ann on 16.05.17.
 */
public interface CategoryDao {

    List<Category> getAllCategories();
}
