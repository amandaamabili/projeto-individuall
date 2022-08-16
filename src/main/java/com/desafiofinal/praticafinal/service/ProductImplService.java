package com.desafiofinal.praticafinal.service;

import com.desafiofinal.praticafinal.dto.ProductDTO;
import com.desafiofinal.praticafinal.exception.ElementNotFoundException;
import com.desafiofinal.praticafinal.model.Product;
import com.desafiofinal.praticafinal.model.Seller;
import com.desafiofinal.praticafinal.repository.IProductRepo;
import com.desafiofinal.praticafinal.repository.ISellerRepo;
import org.springframework.stereotype.Service;

@Service
public class ProductImplService implements IProductService{

    private final IProductRepo productRepo;
    private final ISellerRepo sellerRepo;

    public ProductImplService(IProductRepo productRepo, ISellerRepo sellerRepo) {
        this.productRepo = productRepo;
        this.sellerRepo = sellerRepo;
    }

    /**
     *
     * @param product
     * @return
     */
    @Override
    public Product saveProduct(ProductDTO product) {

        var seller = sellerRepo
                .findById(product.getIdSeller())
                .orElseThrow(() -> new ElementNotFoundException("Seller does not exist"));

        return productRepo.save(buildProduct(product, seller));
    }

    /**
     *
     * @param productDTO
     * @param seller
     * @return
     */
    private Product buildProduct(ProductDTO productDTO, Seller seller){
        return Product.builder()
                .productType(productDTO.getProductType())
                .productName(productDTO.getProductName())
                .validateDate(productDTO.getValidateDate())
                .price(productDTO.getPrice())
                .bulk(productDTO.getBulk())
                .seller(seller)
                .build();
    }
}
