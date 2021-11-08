package com.example.mvc.controller;

import com.example.mvc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductsListController {
    private final ProductService productService;

    @Autowired
    public ProductsListController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/list/products", method = RequestMethod.GET)
    public String getProductsList(@RequestParam(value = "filter", required = false) String filter, Model model) {
        if (filter != null && filter.equals("ordered"))
            model.addAttribute("orderedProductsList", productService.findOrderedProducts());
        else
            model.addAttribute("productsList", productService.findAll());
        return "productsList";
    }

    @RequestMapping(value = "/list/products", method = RequestMethod.POST)
    public String delete(@RequestParam("action") String action,
                         @RequestParam(value = "productId", required = false) Integer productId,
                         @RequestParam(value = "password", required = false) String password) {
        if (action.equals("delete_product")) {
            productService.delete(productId);
        } else if (action.equals("delete_all")) {
            productService.deleteAll(password);
        }
        return "redirect:/list/products";
    }
}
