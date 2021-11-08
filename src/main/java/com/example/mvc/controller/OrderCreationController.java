package com.example.mvc.controller;

import com.example.mvc.model.OrderProduct;
import com.example.mvc.service.OrderService;
import com.example.mvc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class OrderCreationController {
    private final OrderService orderService;
    private final ProductService productService;

    @Autowired
    public OrderCreationController(OrderService orderService, ProductService productService) {
        this.orderService = orderService;
        this.productService = productService;
    }

    @RequestMapping(value = "/create/order", method = RequestMethod.GET)
    public String getCreateOrderPage() {
        return "createOrder";
    }

    @RequestMapping(value = "/create/order", method = RequestMethod.POST)
    public String createOrder(HttpServletRequest req) {
        HttpSession session = req.getSession();
        List<OrderProduct> products = (List<OrderProduct>) session.getAttribute("productsList");
        int productId = Integer.parseInt(req.getParameter("productId"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));

        if (productService.findById(productId) == null) {
            req.setAttribute("error", "productId");
            return "createOrder";
        }

        products = orderService.addOneMoreProduct(productId, quantity, products);
        if (products == null)
            req.setAttribute("error", "alreadyInList");
        else {
            if (req.getParameter("action").equals("Create")) {
                orderService.createOrder(products);
                session.invalidate();
            } else if (req.getParameter("action").equals("Add one more product")) {
                session.setAttribute("productsList", products);
            }
        }
        return "createOrder";
    }
}
