package com.desafiofinal.praticafinal.service;

import com.desafiofinal.praticafinal.dto.WareHouseDTO;
import com.desafiofinal.praticafinal.model.WareHouse;

public interface IWareHouseService {
    WareHouse saveWarehouse(WareHouseDTO wareHouseDTO);
}
