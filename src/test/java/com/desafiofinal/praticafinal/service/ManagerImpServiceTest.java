package com.desafiofinal.praticafinal.service;

import com.desafiofinal.praticafinal.dto.ManagerDTO;
import com.desafiofinal.praticafinal.dto.SellerDTO;
import com.desafiofinal.praticafinal.model.Manager;
import com.desafiofinal.praticafinal.model.Seller;
import com.desafiofinal.praticafinal.model.WareHouse;
import com.desafiofinal.praticafinal.repository.IManagerRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ManagerImpServiceTest {

    @Mock
    private  IManagerRepo managerRepo;

    @Test
    void saveManager(){
        Manager manager = new Manager(  1L, "AMANDA", new WareHouse());

        when(managerRepo.save(any(Manager.class))).thenReturn(manager);

        var service = new ManagerImpService(managerRepo);
        var managerCreated = service.saveManager(new ManagerDTO( 1L,"amanda", new WareHouse()));
        Assertions.assertEquals(manager.getManagerId(), managerCreated.getManagerId());
        Assertions.assertEquals(manager.getManagerName(), managerCreated.getManagerName());

    }

}
