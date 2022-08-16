package com.desafiofinal.praticafinal.dto;

import com.desafiofinal.praticafinal.model.Sector;
import com.desafiofinal.praticafinal.model.WareHouse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class WareHouseDTO {

    @Positive
    @Max(45)
    private Long wareHouseId;

    @NotNull
    @Positive
    @Max(45)
    private Long id_manager;
}