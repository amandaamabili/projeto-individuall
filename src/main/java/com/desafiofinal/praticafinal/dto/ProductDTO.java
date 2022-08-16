package com.desafiofinal.praticafinal.dto;

import com.desafiofinal.praticafinal.model.Product;
import com.desafiofinal.praticafinal.model.Seller;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    @NotBlank(message = "Product name cannot be blank.")
    @Pattern(regexp = "^[A-Z][a-z]*(?: [A-Z][a-z]*)*$",
            message = "The product's name must begin with a capital letter.")
    private String productName;

    @NotBlank(message = "Type name cannot be blank.")
    @Pattern(regexp = "^[A-Z][a-z]*(?: [A-Z][a-z]*)*$",
            message = "The Product Type's name must begin with a capital letter.")
    private String productType;


    private Date validateDate;

    @NotNull
    @Positive
    private Double price;

    @NotNull(message = "Seller Id cannot be null.")
    @Min(value = 0, message = "Seller Id must be a positive number.")
    private Long idSeller;

    @NotNull
    @Positive
    private Double bulk;

}
