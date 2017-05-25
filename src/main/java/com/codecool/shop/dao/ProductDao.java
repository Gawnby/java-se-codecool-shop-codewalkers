package com.codecool.shop.dao;

import com.codecool.shop.model.Supplier;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;

import java.util.List;

/**
 * An interface for ProductDao and Jdbc.
 */
public interface ProductDao {
    /**
     * Add new product for database or data store.
     * @param product which we want to add.
     */
    void add(Product product);

    /**
     * Find a product by an id in data store or database.
     * @param id of the product.
     * @return the Product what we find.
     */
    Product find(int id);

    /**
     * Remove a product from data store or database.
     * @param id of the Product what we want to remove.
     */
    void remove(int id);

    /**
     * Get all Product from data store or database into a list.
     * @return list of all products.
     */
    List<Product> getAll();

    /**
     * Get all products by a Supplier.
     * @param supplier of the products.
     * @return list of products.
     */
    List<Product> getBy(Supplier supplier);
    /**
     * Get all products by a ProductCategory.
     * @param productCategory of the products.
     * @return list of products.
     */
    List<Product> getBy(ProductCategory productCategory);
}
