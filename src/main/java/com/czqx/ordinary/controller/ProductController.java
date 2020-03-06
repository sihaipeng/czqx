package com.czqx.ordinary.controller;

import com.czqx.ordinary.domain.ProductDO;
import com.czqx.ordinary.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/product")
@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/list")
    public List<ProductDO> list(){
        return productService.list();
    }
}
