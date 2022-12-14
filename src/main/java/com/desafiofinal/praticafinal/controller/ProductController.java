package com.desafiofinal.praticafinal.controller;

import com.desafiofinal.praticafinal.dto.ProductDTO;
import com.desafiofinal.praticafinal.exception.ElementNotFoundException;
import com.desafiofinal.praticafinal.model.Product;
import com.desafiofinal.praticafinal.service.IProductService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/api/v1/fresh-products/product")
public class ProductController {

    private final IProductService service;
    public ProductController(IProductService service) {
        this.service = service;
    }

    /**
     * Route used to insert into the database a new product
     * @param product HTML Response 201: Created
     * @return
     */
    @PostMapping
    public ResponseEntity<Object> insertProduct(@RequestBody @Valid  ProductDTO product){
        try{
            Product response = service.saveProduct(product);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/count")
    public ResponseEntity<Object> countProductAtStock(@RequestParam(name = "productName") String productName){
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(service.countProductByNameAtStock(productName));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
