package com.codecool.shop.dao;

import com.codecool.shop.model.ProductCategory;

import java.util.List;

public interface ProductCategoryDao {

    /**
     * Add new ProductCategory for database or data store.
     * @param category which we want to add.
     */
    void add(ProductCategory category);
    /**
     * Find a ProductCategory by an id in data store or database.
     * @param id of the category.
     * @return the ProductCategory what we find.
     */
    ProductCategory find(int id);
    /**
     * Remove a ProductCategory from data store or database.
     * @param id of the category what we want to remove.
     */
    void remove(int id);

    /**
     * Get all ProductCategory from data store or database into a list.
     * @return list of all category.
     */
    List<ProductCategory> getAll();

}
