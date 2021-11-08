package com.example.mvc.service;

import com.example.mvc.dao.OrderDAO;
import com.example.mvc.dto.OrderDTO;
import com.example.mvc.model.Order;
import com.example.mvc.model.OrderProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private final OrderDAO orderDAO;
    private final int userId = 1000 + (int) (Math.random() * 999);

    @Autowired
    public OrderService(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public void createOrder(List<OrderProduct> products) {
        try {
            orderDAO.createOrderWithProducts(Order.createOrder(userId, "new"), products);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<OrderProduct> addOneMoreProduct(int productId, int quantity, List<OrderProduct> products) {
        if (products == null)
            products = new ArrayList<>();
        else
            for (OrderProduct op : products)
                if (productId == op.getProductId())
                    return null;
        products.add(new OrderProduct(productId, quantity));
        return products;
    }

    public List<OrderDTO> findAllOrders() {
        return orderDAO.findAllOrders();
    }
}
