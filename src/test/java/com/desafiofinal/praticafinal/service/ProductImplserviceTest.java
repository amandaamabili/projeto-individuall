package com.desafiofinal.praticafinal.service;

import com.desafiofinal.praticafinal.dto.ProductDTO;
import com.desafiofinal.praticafinal.model.BatchStock;
import com.desafiofinal.praticafinal.model.InBoundOrder;
import com.desafiofinal.praticafinal.model.Product;
import com.desafiofinal.praticafinal.model.Seller;
import com.desafiofinal.praticafinal.repository.IProductRepo;
import com.desafiofinal.praticafinal.repository.ISellerRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static java.util.Collections.singletonList;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class ProductImplserviceTest {

    @Mock
    private  IProductRepo productRepo;
    @Mock
    private  ISellerRepo sellerRepo;


    @Test
    void saveProduct(){

        Seller seller =  new Seller(1L,"Seller", Collections.emptySet());
        Product product = new Product(1L,
                new Date(),
                14,
                "Carnes",
                "Patinho bovino",
                seller,
                24,
                Collections.emptyList());
        when(productRepo.save(any(Product.class))).thenReturn(product);
        when(sellerRepo.findById(anyLong())).thenReturn(Optional.of(seller));

        var service = new ProductImplService(productRepo, sellerRepo);
        var productCreated = service.saveProduct(new ProductDTO (
                "carme",
                "frios",
                new Date(),
                12D,
                1L,
                17D ));


        Assertions.assertEquals(product.getProductName(), productCreated.getProductName());
    }


    @Test
    void countProductStockByName(){
        var batchStock1 = new BatchStock(1L, 12, 14, 20L, 7L, new Date(), new Date(), new Date(), null, null );
        var batchStock2 = new BatchStock(1L, 12, 14, 20L, 7L, new Date(), new Date(), new Date(), null, null );

        Seller seller1 =  new Seller(1L,"Seller1", Collections.emptySet());
        Seller seller2 =  new Seller(2L,"Seller2", Collections.emptySet());
        Product product1 = new Product(1L, new Date(), 14, "Carnes", "Patinho bovino", seller1, 24, singletonList(batchStock1));
        Product product2 = new Product(1L, new Date(), 14, "Carnes", "Patinho bovino", seller2, 24, singletonList(batchStock2));
        when(productRepo.getAllByProductName(any())).thenReturn(Optional.of(List.of(product1, product2)));

        var service = new ProductImplService(productRepo, sellerRepo);
        var productCreated = service.countProductByNameAtStock("Carnes");

        Assertions.assertEquals(14, productCreated);
    }

}
