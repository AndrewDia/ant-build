package com.example.mvc.controller;

import com.example.mvc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductCreationController {
    private final ProductService productService;

    @Autowired
    public ProductCreationController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/create/product", method = RequestMethod.GET)
    public String getCreateProductPage() {
        return "createProduct";
    }

    @RequestMapping(value = "/create/product", method = RequestMethod.POST)
    public String createProduct(@RequestParam("productName") String name,
                              @RequestParam("productPrice") Integer price,
                              @RequestParam("status") String status, Model model) {
        productService.save(name, price, status);
        model.addAttribute("productSuccessful", true);
        return "createProduct";
    }
}
