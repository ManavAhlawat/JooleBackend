package com.example.ReactBackend.Controller;

import com.example.ReactBackend.Service.ProductService;
import com.example.ReactBackend.TO.ProductTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public List<ProductTO> getProducts(){
        return service.getProducts();
    }

    @GetMapping("/productByID/{productID}")
    public ProductTO findProductById(@PathVariable int productID){
        return service.getProductById(productID);
    }

    @GetMapping("/product/{productName}")
    public ProductTO findProductByName(@PathVariable String productName){
        return service.getProductByName(productName);
    }
    @PostMapping("createProduct")
    public void createProduct(@RequestBody ProductTO product){
        service.createProduct(product);
    }

    @PutMapping("/updateProduct")
    public ProductTO updateProduct(@RequestBody ProductTO product){
        return service.updateProduct(product);
    }

    @DeleteMapping("/deleteProduct/{productID}")
    public String deleteProduct(@PathVariable int productID){
        return service.deleteProduct(productID);
    }
}
