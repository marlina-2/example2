package com.ann.spring_web_test.controller;

import com.ann.spring_web_test.model.Category;
import com.ann.spring_web_test.model.Product;
import com.ann.spring_web_test.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by ann on 14.05.17.
 */
@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

   @RequestMapping("/categories")
    public String getAllCategories(Model model){
       model.addAttribute("categories", categoryService.getAllCategories());
       return "categories";
   }

   @RequestMapping
    public String getByName(@RequestParam(value = "name") String name, Model model) {
       Category category = null;

//        for (Category c: categoryList){
//           if (c.getName().equals(name)){
//               category = c;
//           }
//       }

       model.addAttribute("category", category);
        return "category";
   }
}
