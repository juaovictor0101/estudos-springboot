package com.example.springboot.controllers;

import com.example.springboot.dtos.ProductRecordDto;
import com.example.springboot.models.ProductModel;
import com.example.springboot.repositories.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping ("/products")
    public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid ProductRecordDto productRecordDto){
        var productModel = new ProductModel();
        BeanUtils.copyProperties(productRecordDto, productModel);
        return  ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductModel>> getAllProducts(){

        return ResponseEntity.status(HttpStatus.OK).body(productRepository.findAll());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Object> getOneProduct(@PathVariable (value = "id")UUID productId){
        Optional<ProductModel> product0 = productRepository.findById(productId);
        if(product0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found on DB. ");
        }
        return ResponseEntity.status(HttpStatus.OK).body(product0.get());
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable (value = "id") UUID productId,
                                                 @RequestBody @Valid ProductRecordDto productRecordDto){
        Optional<ProductModel> product0 = productRepository.findById(productId);
        if(product0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found on DB.");
        }
        var productModel = product0.get();
        BeanUtils.copyProperties(productRecordDto, productModel);
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.save(productModel));
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable (value = "id") UUID productId) {
        Optional<ProductModel> product0 = productRepository.findById(productId);
        if(product0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found on DB.");
        }
        productRepository.delete(product0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted from DB successfully.");
    }

}
