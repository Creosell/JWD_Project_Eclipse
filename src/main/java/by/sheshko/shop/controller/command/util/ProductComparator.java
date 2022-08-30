package by.sheshko.shop.controller.command.util;

import by.sheshko.shop.bean.Product;
import by.sheshko.shop.dao.pool.ConnectionPool;

import java.util.Comparator;

public class ProductComparator implements Comparator<Product> {
    private static final ProductComparator INSTANCE = new ProductComparator();

    public static ProductComparator getInstance() {
        synchronized (ProductComparator.class) {
            return INSTANCE;
        }
    }

    @Override
    public int compare(Product o1, Product o2) {
        return Integer.compare(o1.getProductID(), o2.getProductID());
    }

    @Override
    public Comparator<Product> reversed() {
        return Comparator.super.reversed();
    }
}
