package com.codecool.shop.model;

import java.util.ArrayList;

/**
 * Supplier model object.
 */

public class Supplier extends BaseModel {

    private static int currentId = 0;

    private ArrayList<Product> products;
    /**
     * Constructor(s).
     *
     * @param name of the Supplier.
     * @param description a short text about the supplier.
     */
    public Supplier(String name, String description) {
        super(name);
        this.id = currentId;
        currentId++;
        this.products = new ArrayList<>();
        this.description = description;
    }
    public Supplier(int id, String name, String description) {
        this(name, description);
        this.id = id;
    }

    /**
     * This method set products in a list for given Supplier.
     *
     * @param products an ArrayList which contains all products.
     */
    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    /**
     * This method return all the products for given supplier in a list.
     *
     * @return <strong>ArrayList</strong> which contains all products.
     */
    public ArrayList getProducts() {
        return this.products;
    }

    /**
     * Add new Product for the products list.
     *
     * @param product which we want to add all products of the Supplier.
     */
    public void addProduct(Product product) {
        this.products.add(product);
    }

    /**
     * This is an override method for the Supplier object.toString().
     *
     * @return all the parameters of the Supplier.
     */
    public String toString() {
        return String.format("id: %1$d, " +
                        "name: %2$s, " +
                        "description: %3$s",
                this.id,
                this.name,
                this.description
        );
    }
}