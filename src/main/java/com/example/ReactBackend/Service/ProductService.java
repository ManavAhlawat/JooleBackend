package com.example.ReactBackend.Service;

import com.example.ReactBackend.Entity.Product;
import com.example.ReactBackend.Entity.User;
import com.example.ReactBackend.Repository.ProductRepository;
import com.example.ReactBackend.Repository.UserRepository;
import com.example.ReactBackend.TO.ProductTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    public List<ProductTO> getProducts() {
        List<ProductTO> productsToReturn = new ArrayList<>();
        for(Product p: productRepository.findAll()){
            productsToReturn.add(createProductTO(p));
        }
        return productsToReturn;
    }

    public ProductTO getProductById(int productID){
        return createProductTO(productRepository.findById(productID).orElse(null));
    }

    public ProductTO getProductByName(String productName){
        return createProductTO(productRepository.findByProductName(productName));
    }

    public String deleteProduct(int productID){
        if(productRepository.existsById(productID)) {
            Product productToDelete = productRepository.findById(productID).orElse(null);
            User userOfProduct = productToDelete.getUser();
            userOfProduct.getProducts().remove(productToDelete);
            userRepository.save(userOfProduct);
            productRepository.deleteById(productID);
            return "Product removed: " + productID;
        }else{
            return "No Product to delete by id: "+ productID;
        }
    }

    public ProductTO updateProduct(ProductTO product){
        System.out.println("product code to update "+ product.getProductID());
        Product existingProduct = productRepository.findById(product.getProductID()).orElse(null);
        System.out.println(existingProduct.toString());
        if(existingProduct != null) {
            existingProduct.setProductName(product.getProductName());
            existingProduct.setUser(UserService.createUserEntity(product.getUser()));
            existingProduct = productRepository.save(existingProduct);
            return createProductTO(existingProduct);
        }
        return null;
    }

    public boolean createProduct(ProductTO product){
        Product productEntity = createProductEntity(product);
        productEntity = productRepository.save(productEntity);
        return true;
    }

    public static Product createProductEntity(ProductTO productTO){
        Product productEntity = new Product();
        productEntity.setProductName(productTO.getProductName());
        if(productTO.getUser() != null)
            productEntity.setUser(UserService.createUserEntity(productTO.getUser()));
        productEntity.setProductID(productTO.getProductID());
        return productEntity;
    }
    public static ProductTO createProductTO(Product productEntity){
        ProductTO productTO = new ProductTO();
        productTO.setProductID(productEntity.getProductID());
        productTO.setProductName(productEntity.getProductName());
        productTO.setUser(UserService.createUserTO(productEntity.getUser()));
        return productTO;
    }
}
