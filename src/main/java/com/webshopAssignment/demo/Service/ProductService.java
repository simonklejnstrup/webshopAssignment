package com.webshopAssignment.demo.Service;

import com.webshopAssignment.demo.Model.Product;
import com.webshopAssignment.demo.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> readAll(){
        List<Product> productList = new ArrayList<>();
        for (Product p : productRepository.readAll()){
            productList.add(p);
        }

        return productList;
    }

    public void create(Product product){
        productRepository.create(product);
    }

    public void update(Product product){

        productRepository.update(product);
    }

    public Product read(long id){
        return productRepository.read(id);
    }

    public void delete(Long id){
         productRepository.delete(id);
    }
}
