package com.codecool.shop.model;

import java.util.ArrayList;

/**
 * ProductCategory model object.
 */
public class ProductCategory extends BaseModel {

    private static int currentId = 0;

    private String department;
    private ArrayList<Product> products;
    /**
     * Constructor(s).
     *
     * @param name of the ProductCategory.
     * @param  department where the category belongs (etc. Hardware)
     * @param description a short text about the category.
     */
    public ProductCategory(String name, String department, String description) {
        super(name);
        this.id = currentId;
        currentId++;
        this.description = description;
        this.products = new ArrayList<>();
        this.department = department;
    }

    public ProductCategory(int id, String name, String department, String description) {
        this(name, description, department);
        this.id = id;
    }

    /**
     * Get the department of the ProductCategory.
     *
     * @return <strong>String</strong> what department conatins.
     */
    public String getDepartment() {
        return department;
    }

    /**
     * This method set a new value for the department.
     *
     * @param department the new string which we want to set for department.
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     *This method set products in a list for given ProductCategory.
     *
     * @param products an ArrayList which contains all products.
     */
    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    /**
     * This method return all the products for given category in a list.
     *
     * @return <strong>ArrayList</strong> which contains all products.
     */
    public ArrayList getProducts() {
        return this.products;
    }

    /**
     * Add new Product for the products list.
     *
     * @param product which we want to add all products of the ProductCategory.
     */
    public void addProduct(Product product) {
        this.products.add(product);
    }

    /**
     * This is an override method for the ProductCategory object.toString().
     *
     * @return all the parameters of the ProductCategory.
     */
    public String toString() {
        return String.format(
                "id: %1$d," +
                        "name: %2$s, " +
                        "department: %3$s, " +
                        "description: %4$s",
                this.id,
                this.name,
                this.department,
                this.description);
    }
}