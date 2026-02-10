package id.cs.ui.ac.advprog.eshop.service;

import id.cs.ui.ac.advprog.eshop.model.Product;
import java.util.List;

public interface ProductService {
    public Product create(Product product);
    public List<Product> findAll();
    public Product findById(String productId);
    public void update(Product product);
}


