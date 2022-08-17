package com.desafiofinal.praticafinal.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date validateDate;
    private double price;
    private String productType;
    private String productName;

    @ManyToOne
    @JoinColumn(name = "id_seller", nullable = false)
    private Seller seller;

    private double bulk;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<BatchStock> batchList;
}
