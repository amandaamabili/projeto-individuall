package com.desafiofinal.praticafinal.service;

import com.desafiofinal.praticafinal.dto.ProductDTO;
import com.desafiofinal.praticafinal.dto.WareHouseDTO;
import com.desafiofinal.praticafinal.exception.ElementNotFoundException;
import com.desafiofinal.praticafinal.model.Manager;
import com.desafiofinal.praticafinal.model.Product;
import com.desafiofinal.praticafinal.model.Seller;
import com.desafiofinal.praticafinal.model.WareHouse;
import com.desafiofinal.praticafinal.repository.IManagerRepo;
import com.desafiofinal.praticafinal.repository.IWareHouseRepo;
import org.springframework.stereotype.Service;

@Service
public class WareHouseImpService implements IWareHouseService{

    private final IManagerRepo managerRepo;
    private final IWareHouseRepo wareHouseRepo;

    public WareHouseImpService(IManagerRepo managerRepo, IWareHouseRepo wareHouseRepo) {
        this.managerRepo = managerRepo;
        this.wareHouseRepo = wareHouseRepo;
    }

    @Override
    public WareHouse saveWarehouse(WareHouseDTO wareHouseDTO) {


            var manager = managerRepo
                    .findById(wareHouseDTO.getId_manager())
                    .orElseThrow(() -> new ElementNotFoundException("Manager does not exist"));

            WareHouse wareHouseSaved = wareHouseRepo.save(buildProduct(wareHouseDTO, manager));
            return wareHouseSaved;

    }

    private WareHouse buildProduct(WareHouseDTO wareHouseDTO, Manager manager){
        return WareHouse.builder()
                .manager(manager)
                .build();
    }
}
