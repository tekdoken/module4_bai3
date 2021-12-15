package baitap_1.service;


import baitap_1.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void update(int id, Product product);

    void remove(int id);
    public List<Product> findByName(String name);
}
