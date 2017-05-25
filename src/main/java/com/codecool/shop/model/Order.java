package com.codecool.shop.model;



import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.implementation.ProductDaoWithJdbc;
import spark.Request;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Order object.
 */
public class Order {

    private static int currentId = 0;

    private int id;
    private Set<Lineitem> orderLines = new LinkedHashSet<>();
    private int totalQuantity = 0;
    private double total = 0;


    public Order(){
        this.id = currentId;
        currentId++;
    }

    /**
     *Get an order from the session.
     *
     * @return an Order object.
     */
    public static Order getOrder(Request request){
        Order myOrder;
        if (request.session().attribute("order") != null){
            myOrder = request.session().attribute("order");
        } else {
            myOrder = new Order();
            request.session().attribute("order", myOrder);
        }
        return myOrder;
    }

    /**
     * Get a set of lineitems.
     *
     * @return Set which contains the lineitems of the Order.
     */
    public Set<Lineitem> getOrderLines() {
        return orderLines;
    }

    /**
     * Get a lineitem by an id.
     *
     * @param id for the Lintitem.
     * @return Linitem which find by the id.
     */
    public Lineitem getLine(int id)  {
        return orderLines.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    /**
     * Refresh the total price of the order.
     *
     * @param total which we add to total price.
     */
    public void addToTotal(float total) {
        this.total += total;
    }

    /**
     * Raise the total quantity of the items in the Order.
     *
     * @param total which we add to totalQuantity.
     */
    public void addToTotalQuantity(int total){
        totalQuantity += total;
    }

    /**
     * This method extract from the total price of the Order.
     *
     * @param total that we want to extract from the total.
     */
    public void subFromTotal(float total) {
        this.total -= total;
    }

    /**
     * Add new item to the order.
     *
     * @param line the Lineitem which we want to add to the Order.
     * @return <strong>boolean</strong>.
     */
    public boolean addLine(Lineitem line){
        for (Lineitem l: orderLines){
            if (line.getProduct().equals(l.getProduct())){
                return false;
            }
        }
        orderLines.add(line);
        total += line.getLinePrice();
        totalQuantity += line.getQuantity();
        return true;
    }

    /**
     * This method remove item from the Product.
     *
     * @param line which we want to remove.
     */

    public void removeLine (Lineitem line) {
        orderLines.remove(line);
        totalQuantity -= line.getQuantity();
    }

    /**
     * Get the totalQuantity of the Order.
     *
     * @return <strong>int</strong> the totalQuantity.
     */
    public int getTotalQuantity(){
        return  totalQuantity;
    }

    /**
     * Add item to the Order by an id.
     *
     * @param id of the item which we want to add .
     */
    public void addItem(int id){
        ProductDao productDataStore = ProductDaoWithJdbc.getInstance();
        Lineitem line = new Lineitem(productDataStore.find(id));
        addLine(line);
    }

    /**
     * Get the id of the Order.
     *
     * @return <strong>int</strong> id.
     */

    public int getId() {
        return id;
    }

    /**
     * Get the total price of the Order.
     *
     * @return <strong>double</strong> total.
     */

    public double getTotal() {
        return Math.round(total * 100d) / 100d;
    }

    /**
     * this is an override method for the Order object.toString().
     * @return all the parameters of the Order.
     */
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderLines=" + orderLines +
                ", total=" + total +
                '}';
    }
}
