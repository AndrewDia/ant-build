package com.example.mvc.controller;

import com.example.mvc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrdersListController {
    private final OrderService orderService;

    @Autowired
    public OrdersListController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping("/list/orders")
    public String getOrderListPage(Model model) {
        model.addAttribute("ordersList", orderService.findAllOrders());
        return "ordersList";
    }
}