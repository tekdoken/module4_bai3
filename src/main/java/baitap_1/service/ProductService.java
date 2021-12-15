package baitap_1.service;

import baitap_1.model.Product;
import thuchanh1.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService {
    private static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "as", 11, "assa", "ew"));
        products.add(new Product(2, "a1s", 11, "as21sa", "ew"));
        products.add(new Product(3, "as2", 11, "as32sa", "ew"));
        products.add(new Product(4, "as3", 11, "a43ssa", "ew"));
        products.add(new Product(5, "as4", 11, "ass54a", "ew"));
    }


    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public Product findById(int id) {
        for (Product product : products
        ) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void update(int id, Product product) {
        products.set(findIndexById(id), product);
    }

    @Override
    public void remove(int id) {
        products.remove(findIndexById(id));
    }

    public int findIndexById(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
}
