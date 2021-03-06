package com.codecool.shop.model;

import sun.misc.Request;

/**
 * Created by tahin on 2017.05.02..
 */
public class Lineitem {

    private static int currentId = 0;

    private int id;
    private Product product;
    private int quantity = 1;
    private double linePrice;

    public Lineitem(Product product){
        this.id = currentId;
        currentId++;
        this.product = product;
        this.linePrice = product.getDefaultPrice();
    }

    public double getLinePrice() {
        return Math.round(linePrice * 100d) / 100d;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Lineitem{" +
                "product=" + product +
                ", quantity=" + quantity +
                ", linePrice=" + linePrice +
                '}';
    }

    public void addOneToQuantity(spark.Request request){
        this.quantity += 1;
        this.linePrice += this.product.getDefaultPrice();

        Order.getOrder(request).addToTotal(this.getProduct().getDefaultPrice());
        Order.getOrder(request).addToTotalQuantity(1);

    }

    public boolean subOneFromQuantity(spark.Request request){
        this.quantity -= 1;
        this.linePrice -= this.product.getDefaultPrice();
        Order.getOrder(request).subFromTotal(this.getProduct().getDefaultPrice());
        return (quantity <= 0);
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
