package com.desafiofinal.praticafinal.dto;

import com.desafiofinal.praticafinal.model.Sector;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SectorDTO {

    private Long sectorId;

    @NotBlank(message = "Product name cannot be blank.")
    @Pattern(regexp = "^[A-Z][a-z]*(?: [A-Z][a-z]*)*$",
            message = "The product's name must begin with a capital letter.")
    private String category;

    @NotNull
    @Positive
    private Double capacity;

    @NotNull(message = "WareHouse Id cannot be null.")
    @Min(value = 0, message = "WareHouse Id must be a positive number.")
    private Long idWareHouse;

    public SectorDTO(Sector sector) {
        this.sectorId = sector.getSectorId();
        this.category = sector.getCategory();
        this.capacity = sector.getCapacity();
        this.idWareHouse = sector.getWareHouse().getWareHouseId();
    }

}
