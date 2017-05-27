package com.ann.spring_web_test.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ann on 14.05.17.
 */
public class Category {


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Category(){}
    public Category(String name, String description, List<Product> products) {
        this.name = name;
        this.description = description;
        this.productList = productList;
    }

    private String name;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;

    public void setProduct(Product p) {
        if (this.productList == null) productList = new ArrayList<>();
        this.productList.add(p);
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    private List<Product> productList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (name != null ? !name.equals(category.name) : category.name != null) return false;
        return description != null ? description.equals(category.description) : category.description == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}