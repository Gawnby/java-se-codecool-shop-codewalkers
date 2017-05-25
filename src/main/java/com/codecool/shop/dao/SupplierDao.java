package com.codecool.shop.dao;

import com.codecool.shop.model.Supplier;

import java.util.List;

public interface SupplierDao {

    /**
     * Add new supplier for database or data store.
     * @param supplier which we want to add.
     */
    void add(Supplier supplier);
    /**
     * Find a Supplier by an id in data store or database.
     * @param id of the Supplier.
     * @return the Supplier what we find.
     */
    Supplier find(int id);
    /**
     * Remove a supplier from data store or database.
     * @param id of the Supplier what we want to remove.
     */
    void remove(int id);

    /**
     * Get all Supplier from data store or database into a list.
     * @return list of all supplier.
     */
    List<Supplier> getAll();
}
