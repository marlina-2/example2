package com.ann.spring_web_test.dao;

import com.ann.spring_web_test.model.Category;
import com.ann.spring_web_test.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by ann on 16.05.17.
 */
@Repository
public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    private DataSource dataSource;



    public List<Category> getAllCategories() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Category> result = null;
        String query = "SELECT c.name as category_name, c.description as category_description, p.name as product_name, p.price, p.description as product_description FROM CATEGORIES c"
                         + " JOIN PRODUCTS p ON c.id = p.fk_category_id;";
        try {
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            result = getCategoriesFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    private List<Category> getCategoriesFromResultSet(ResultSet resultSet) throws SQLException {
        List<Category> result = new ArrayList<Category>();
        while (resultSet.next()){
            Category category = new Category();
            category.setName(resultSet.getString("category_name"));
            category.setDescription(resultSet.getString("category_description"));

            if (result.contains(category)) {
                Category categoryFromResult = result
                        .stream()
                        .filter(c -> c.equals(category))
                        .findFirst()
                        .get();
                categoryFromResult.setProduct(getProductFromResultSet(resultSet));
            } else {
                category.setProduct(getProductFromResultSet(resultSet));
                result.add(category);
            }
        }
        return result;
    }

    private Product getProductFromResultSet(ResultSet resultSet) throws SQLException {
        Product p = new Product();
        p.setName(resultSet.getString("product_name"));
        p.setPrice(Double.parseDouble(resultSet.getString("price")));
        p.setDescription(resultSet.getString("product_description"));
        return p;
    }
}
