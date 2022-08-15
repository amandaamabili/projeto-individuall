package com.desafiofinal.praticafinal.service;

import com.desafiofinal.praticafinal.dto.WareHouseDTO;
import com.desafiofinal.praticafinal.model.Manager;
import com.desafiofinal.praticafinal.model.WareHouse;
import com.desafiofinal.praticafinal.repository.IManagerRepo;
import com.desafiofinal.praticafinal.repository.IWareHouseRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class WareHouseImpServiceTest {

    @Mock
    private  IManagerRepo managerRepo;

    @Mock
    private  IWareHouseRepo wareHouseRepo;


    @Test
    void saveWareHouse(){

        Manager manager =  new Manager(1L,"Amanda", new WareHouse());
        WareHouse wareHouse = new WareHouse(1L,
                manager,
                Collections.emptyList());
        when(wareHouseRepo.save(any(WareHouse.class))).thenReturn(wareHouse);
        when(managerRepo.findById(anyLong())).thenReturn(Optional.of(manager));

        var service = new WareHouseImpService(managerRepo, wareHouseRepo);
        var wareHouseCreated = service.saveWarehouse(new WareHouseDTO(
               1L,
               1L));


        Assertions.assertEquals(wareHouse.getManager(), wareHouseCreated.getManager());
    }
}
