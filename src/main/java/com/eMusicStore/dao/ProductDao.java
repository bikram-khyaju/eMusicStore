package com.eMusicStore.dao;

import com.eMusicStore.model.Product;

import java.util.List;

/**
 * Created by khyajubikram on 3/10/2017.
 */
public interface ProductDao {

    void addProduct(Product product);

    Product getProductById(long id);

    List<Product> getAllProducts();

    void deleteProduct(long id);

    void editProduct(Product product);
}
