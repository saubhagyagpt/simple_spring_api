package com.fabricate.productservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.fabricate.productservice.dto.ProductRequest;

import com.fabricate.productservice.service.ProductService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("api/product-service")
public class ProductController {
    

    @Autowired
    private ProductService productService;

    // http://localhost:8081/api/product-service/save
    @PostMapping("/save")
    public ResponseEntity<?> addProduct(@RequestBody ProductRequest productRequest){
        productService.saveProduct(productRequest);
        return new ResponseEntity<>("Product is added successfully",HttpStatus.CREATED);
    }

    // http://localhost:8081/api/product-service/getproduct/5
    @GetMapping("/getproduct/{id}")
    public ResponseEntity<?> getProductById(@PathVariable String id){
        return new ResponseEntity<>(productService.getProduct(id), HttpStatus.OK);
    }

    // http://localhost:8081/api/product-service/getproducts
    @GetMapping("/getproducts/")
    public ResponseEntity<?> getProducts(){
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    // http://localhost:8081/api/product-service/updateproduct/{id}
    @PutMapping("/updateproduct/{id}")
    public ResponseEntity<?> modifyproduct(@PathVariable String id, @RequestBody ProductRequest productRequest ){
        productService.updateProduct(id, productRequest);
        return new ResponseEntity<>("Product is updated Successfully", HttpStatus.OK);
    }

    // http://localhost:8081/api/product-service/deleteproduct/{id}
    @DeleteMapping("/deleteproduct/{id}")
    public ResponseEntity<?> deleteproductById(@PathVariable String id){
        productService.deleteProduct(id);
        return new ResponseEntity<>("Product is deleted successfully", HttpStatus.OK);
    }


    // @ExceptionHandler(ResourceNotFoundException.class)
    // public ResponseEntity<CustomErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest){

    //     CustomErrorDetails customErrorDetails = new CustomErrorDetails(
    //         LocalDateTime.now(),
    //         exception.getMessage(),
    //         webRequest.getDescription(false),
    //         "Product is not found"
    //     );

    //     return new ResponseEntity<>(customErrorDetails,HttpStatus.NOT_FOUND);
    // }

    // @ExceptionHandler(Exception.class)
    // public ResponseEntity<CustomErrorDetails> handleGlobalException(Exception exception, WebRequest webRequest){

    //     CustomErrorDetails customErrorDetails = new CustomErrorDetails(
    //         LocalDateTime.now(),
    //         exception.getMessage(),
    //         webRequest.getDescription(false),
    //         "INTERNAL SERVER ERROR"
    //     );

    //     return new ResponseEntity<>(customErrorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
    // }
}