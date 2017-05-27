package com.ann.spring_web_test.service;

import com.ann.spring_web_test.dao.CategoryDao;
import com.ann.spring_web_test.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ann on 27.05.17.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;


    public List<Category> getAllCategories() {
        return categoryDao.getAllCategories();
    }
}
