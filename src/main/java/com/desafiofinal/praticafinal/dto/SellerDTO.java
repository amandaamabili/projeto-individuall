package com.desafiofinal.praticafinal.dto;

import com.desafiofinal.praticafinal.model.Seller;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SellerDTO {

//    private Optional<Long> id;

    //    private long idSeller;
    private String sellerName;



//    public SellerDTO(Seller seller) {
////        this.idSeller = seller.getId();
//        this.sellerName = seller.getSellerName();
//    }
//    public Seller toEntity() {
//        return new Seller(this.sellerName);
//    }
}