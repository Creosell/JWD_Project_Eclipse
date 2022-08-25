package by.sheshko.shop.bean;

import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = 574829538859146812L;
    private int productID;
    private String title;
    private String description;
    private String category;
    private double price;
    private int availableQuantity;
    private int quantityInOrders;

    public Product(int productID, String title, String description, String category, double price, int availableQuantity, int quantityInOrders) {
        this.productID = productID;
        this.title = title;
        this.description = description;
        this.category = category;
        this.price = price;
        this.availableQuantity = availableQuantity;
        this.quantityInOrders = quantityInOrders;
    }

    //TODO equals hash
    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", availableQuantity=" + availableQuantity +
                ", quantityInOrders=" + quantityInOrders +
                '}';
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
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
