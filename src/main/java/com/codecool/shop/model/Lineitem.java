package com.codecool.shop.model;

/**
 * LineItem object.
 */
public class Lineitem {

    private static int currentId = 0;

    private int id;
    private Product product;
    private int quantity = 1;
    private double linePrice;

    /**
     * Constructor.
     *
     * @param product a Product object.
     */
    public Lineitem(Product product){
        this.id = currentId;
        currentId++;
        this.product = product;
        this.linePrice = product.getDefaultPrice();
    }

    /**
     * Get the price of the products in one line.
     *
     * @return <strong>double</strong> the price of the product(s).
     */
    public double getLinePrice() {
        return Math.round(linePrice * 100d) / 100d;
    }

    /**
     * Get the id of the LineItem.
     *
     * @return <strong>int</strong> which is the id.
     */
    public int getId() {
        return id;
    }

    /**
     * This is an override method for Lineitem object.toString().
     *
     * @return the all the parameters of the Lineitem.
     */
    @Override
    public String toString() {
        return "Lineitem{" +
                "product=" + product +
                ", quantity=" + quantity +
                ", linePrice=" + linePrice +
                '}';
    }

    /**
     * This method raise the quantity of the lineitem .
     *
     */
    public void addOneToQuantity(spark.Request request){
        this.quantity += 1;
        this.linePrice += this.product.getDefaultPrice();

        Order.getOrder(request).addToTotal(this.getProduct().getDefaultPrice());
        Order.getOrder(request).addToTotalQuantity(1);

    }

    /**
     * This method extract from the lineitem quantity.
     *
     * @return <strong>boolean</strong> which depends from the quantity.
     */
    public boolean subOneFromQuantity(spark.Request request){
        this.quantity -= 1;
        this.linePrice -= this.product.getDefaultPrice();
        Order.getOrder(request).subFromTotal(this.getProduct().getDefaultPrice());
        return (quantity <= 0);
    }

    /**
     * This method return the product which we add to the line .
     *
     * @return <strong>Product</strong> of the line.
     */
    public Product getProduct() {
        return product;
    }

    /**
     * This method return the quantity of the product in the line.
     *
     * @return <strong>int</strong> quantity.
     */
    public int getQuantity() {
        return quantity;
    }
}
