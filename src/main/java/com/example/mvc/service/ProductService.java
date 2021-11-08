package com.example.mvc.service;

import com.example.mvc.dao.ProductDAO;
import com.example.mvc.dto.OrderedProductDTO;
import com.example.mvc.model.Product;
import com.example.mvc.model.ProductsStatus;
import com.example.mvc.util.ConnectionProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ProductService {
    private final ProductDAO productDAO;

    @Autowired
    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public void save(String name, int price, String status) {
        productDAO.insertProduct(Product.createProduct(name, price, ProductsStatus.fromString(status)));
    }

    public List<OrderedProductDTO> findOrderedProducts() {
        return productDAO.findOrderedProducts();
    }

    public List<Product> findAll() {
        return productDAO.findAllProducts();
    }

    public Product findById(int id) {
        return productDAO.getProduct(id);
    }

    public void delete(int id) {
        productDAO.deleteProduct(id);
    }

    public void deleteAll(String password) {
        if (password.equals(ConnectionProperties.getPassword())) {
            try {
                productDAO.deleteAllProducts();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
