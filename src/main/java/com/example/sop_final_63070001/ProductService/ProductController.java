package com.example.sop_final_63070001.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/getProducts", method = RequestMethod.GET)
    public ResponseEntity<?> getProduct(){
        List<Product> product = productService.retrieveProduct();
        return ResponseEntity.ok(product);
    }
}
