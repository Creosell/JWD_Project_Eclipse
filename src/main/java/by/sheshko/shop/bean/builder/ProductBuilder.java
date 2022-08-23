package by.sheshko.shop.bean.builder;

import by.sheshko.shop.bean.Product;

public class ProductBuilder implements BuilderInterface {
    private int productID;
    private String title;
    private String description;
    private String category;
    private double price;
    private int availableQuantity;
    private int quantityInOrders;

    public ProductBuilder() {
    }

    public ProductBuilder productID(Integer productID) {
        this.productID = productID;
        return this;
    }

    public ProductBuilder title(String title) {
        this.title = title;
        return this;
    }

    public ProductBuilder description(String description) {
        this.description = description;
        return this;
    }

    public ProductBuilder category(String category) {
        this.category = category;
        return this;
    }

    public ProductBuilder price(Double price) {
        this.price = price;
        return this;
    }

    public ProductBuilder availableQuantity(Integer availableQuantity) {
        this.availableQuantity = availableQuantity;
        return this;
    }

    public ProductBuilder quantityInOrders(Integer quantityInOrders) {
        this.quantityInOrders = quantityInOrders;
        return this;
    }

    @Override
    public Product build() {
        return new Product(productID, title, description, category, price, availableQuantity, quantityInOrders);
    }
}
