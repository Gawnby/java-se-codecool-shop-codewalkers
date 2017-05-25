package com.codecool.shop.model;

import java.util.Currency;

/**
 * Product model object.
 */
public class Product extends BaseModel {

    private static int currentId = 0;
    private float defaultPrice;
    private Currency defaultCurrency;
    private ProductCategory productCategory;
    private Supplier supplier;

    /**
     * Constructor(s).
     *
     * @param name is the name of the product what we created.
     * @param defaultPrice is the price of product(float number).
     * @param currencyString is the currency which the price in it. (etc. EUR)
     * @param description is a short text about the product.
     * @param productCategory is the ProductCategory object's name.
     * @param supplier is te Supplier object's name.
     */
    public Product(String name, float defaultPrice, String currencyString, String description, ProductCategory productCategory, Supplier supplier) {
        super(name, description);
        this.id = currentId;
        currentId++;
        this.setPrice(defaultPrice, currencyString);
        this.setSupplier(supplier);
        this.setProductCategory(productCategory);
    }
    public Product(int id, String name, float defaultPrice, String currencyString, String description, ProductCategory productCategory, Supplier supplier) {
        this(name, defaultPrice, currencyString, description, productCategory, supplier);
        this.id = id;
    }

    /**
     * Get the default price of the product.
     *
     *@return <strong>float</strong> the defaultPrice variable of the Product.
     */
    public float getDefaultPrice() {
        return defaultPrice;
    }

    /**
     * Set a new value for the default price of the product.
     *
     * @param defaultPrice is the new value what we want to defaultPrice.
     */
    public void setDefaultPrice(float defaultPrice) {
        this.defaultPrice = defaultPrice;
    }

    /**
     * This method return the defaultCurrency of the Product.
     *
     * @return <strong>Currency</strong> , the currency which the price in it.
     */
    public Currency getDefaultCurrency() {
        return defaultCurrency;
    }

    /**
     * Set a new currency for the Product.
     *
     * @param defaultCurrency is the new currency which we want to defaultCurrency.
     */
    public void setDefaultCurrency(Currency defaultCurrency) {
        this.defaultCurrency = defaultCurrency;
    }

    /**
     * This method is return the price of the Product.
     *
     * @return <strong>String</strong> , the default price with currency in one string.
     */
    public String getPrice() {
        return String.valueOf(this.defaultPrice) + " " + this.defaultCurrency.toString();
    }

    /**
     * Set new value for the defaultPrice.
     *
     * @param price the new value what we set.
     * @param currency the new currency what we set.
     */
    public void setPrice(float price, String currency) {
        this.defaultPrice = price;
        this.defaultCurrency = Currency.getInstance(currency);
    }

    /**
     * Get the category of a Product.
     *
     * @return <strong>ProductCategory</strong> object of a Product.
     */
    public ProductCategory getProductCategory() {
        return productCategory;
    }

    /**
     * This method add a new category for the Product.
     *
     * @param productCategory is the new ProductCategory object which we want to set for
     *                       the Product.
     */
    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
        this.productCategory.addProduct(this);
    }

    /**
     * Get the supplier of a Product.
     *
     * @return <strong>Supplier</strong> object of the Product.
     */
    public Supplier getSupplier() {
        return supplier;
    }

    /**
     * This method add a new supplier for the Product.
     *
     * @param supplier is the new Supplier object which we want to set
     *                for the Product.
     */
    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
        this.supplier.addProduct(this);
    }

    /**
     * This is an override method for Product object.toString().
     *
     * @return the parameters of the Product.
     */
    @Override
    public String toString() {
        return String.format("id: %1$d, " +
                        "name: %2$s, " +
                        "defaultPrice: %3$s, " +
                        "defaultCurrency: %4$s, " +
                        "productCategory: %5$s, " +
                        "supplier: %6$s",
                this.id,
                this.name,
                this.defaultPrice,
                this.defaultCurrency.toString(),
                this.productCategory.getName(),
                this.supplier.getName());
    }
}
