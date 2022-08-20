package by.sheshko.shop.bean;

import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = 574829538859146812L;
    private String productID;
    private String title;
    private String description;
    private String category;
    private double price;
    private int availableQuantity;
    private int quantityInOrders;

    //TODO equals hash
    public Product() {
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(final double price) {
        this.price = price;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(final int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public int getQuantityInOrders() {
        return quantityInOrders;
    }

    public void setQuantityInOrders(final int quantityInOrders) {
        this.quantityInOrders = quantityInOrders;
    }

}
