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

//    @Autowired
//    private UserRepository userRepository;

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
//        if(productRepository.existsById(productID)) {
//            Product productToDelete = productRepository.findById(productID).orElse(null);
//            User userOfProduct = productToDelete.getUser();
//            userOfProduct.getProducts().remove(productToDelete);
//            userRepository.save(userOfProduct);
            productRepository.deleteById(productID);
            return "Product removed: " + productID;
//        }else{
//            return "No Product to delete by id: "+ productID;
//        }
    }

    public ProductTO updateProduct(ProductTO product){
        System.out.println("product code to update "+ product.getProductID());
        Product existingProduct = productRepository.findById(product.getProductID()).orElse(null);
        System.out.println(existingProduct.toString());
        if(existingProduct != null) {
            existingProduct.setProductName(product.getProductName());
            existingProduct.setModelYear(product.getModelYear());
            existingProduct.setBrand(product.getBrand());
            existingProduct.setAirflow(product.getAirflow());
            existingProduct.setMaxPower(product.getMaxPower());
            existingProduct.setSound(product.getSound());
            existingProduct.setDiameter(product.getDiameter());
            existingProduct.setHeight(product.getHeight());
            existingProduct.setManufacturer(product.getManufacturer());
            existingProduct.setSeries(product.getSeries());
            existingProduct.setModel(product.getModel());
            existingProduct.setUseType(product.getUseType());
            existingProduct.setApplication(product.getApplication());
            existingProduct.setMountLocation(product.getMountLocation());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setType(product.getType());
            existingProduct.setImage(product.getImage());
//            existingProduct.setUser(UserService.createUserEntity(product.getUser()));
            existingProduct = productRepository.save(existingProduct);
            return createProductTO(existingProduct);
        }
        return null;
    }

    public boolean createProduct(ProductTO product){
        Product productEntity = createProductEntity(product);
        productRepository.save(productEntity);
        return true;
    }

    public static Product createProductEntity(ProductTO productTO){
        Product productEntity = new Product();
        productEntity.setProductName(productTO.getProductName());
//        if(productTO.getUser() != null)
//            productEntity.setUser(UserService.createUserEntity(productTO.getUser()));
        productEntity.setProductID(productTO.getProductID());
        productEntity.setBrand(productTO.getBrand());
        productEntity.setAirflow(productTO.getAirflow());
        productEntity.setMaxPower(productTO.getMaxPower());
        productEntity.setSound(productTO.getSound());
        productEntity.setDiameter(productTO.getDiameter());
        productEntity.setHeight(productTO.getHeight());
        productEntity.setManufacturer(productTO.getManufacturer());
        productEntity.setSeries(productTO.getSeries());
        productEntity.setModel(productTO.getModel());
        productEntity.setUseType(productTO.getUseType());
        productEntity.setApplication(productTO.getApplication());
        productEntity.setMountLocation(productTO.getMountLocation());
        productEntity.setPrice(productTO.getPrice());
        productEntity.setType(productTO.getType());
        productEntity.setImage(productTO.getImage());
        return productEntity;
    }
    public static ProductTO createProductTO(Product productEntity){
        ProductTO productTO = new ProductTO();
        productTO.setProductID(productEntity.getProductID());
        productTO.setProductName(productEntity.getProductName());
        productTO.setBrand(productEntity.getBrand());
        productTO.setAirflow(productEntity.getAirflow());
        productTO.setMaxPower(productEntity.getMaxPower());
        productTO.setSound(productEntity.getSound());
        productTO.setDiameter(productEntity.getDiameter());
        productTO.setHeight(productEntity.getHeight());
        productTO.setManufacturer(productEntity.getManufacturer());
        productTO.setSeries(productEntity.getSeries());
        productTO.setModel(productEntity.getModel());
        productTO.setUseType(productEntity.getUseType());
        productTO.setApplication(productEntity.getApplication());
        productTO.setMountLocation(productEntity.getMountLocation());
        productTO.setPrice(productEntity.getPrice());
        productTO.setType(productEntity.getType());
        productTO.setImage(productEntity.getImage());
        //productTO.setUser(UserService.createUserTO(productEntity.getUser()));
        return productTO;
    }
}
