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
public class SectorRequestDTO {
//
//    @NotNull
//    @Positive
    private Long sectorId;

    private String category;

    private Double capacity;


    private Long idWareHouse;

    public SectorRequestDTO(Sector sector) {
        this.sectorId = sector.getSectorId();
        this.category = sector.getCategory();
        this.capacity = sector.getCapacity();
        this.idWareHouse = sector.getWareHouse().getWareHouseId();
    }

}
