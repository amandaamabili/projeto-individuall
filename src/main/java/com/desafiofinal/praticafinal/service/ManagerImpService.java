package com.desafiofinal.praticafinal.service;

import com.desafiofinal.praticafinal.dto.ManagerDTO;
import com.desafiofinal.praticafinal.model.Manager;
import com.desafiofinal.praticafinal.model.Seller;
import com.desafiofinal.praticafinal.repository.IManagerRepo;
import lombok.val;
import org.springframework.stereotype.Service;

@Service
public class ManagerImpService implements IManagerService{

    private final IManagerRepo managerRepo;

    public ManagerImpService(IManagerRepo managerRepo) {
        this.managerRepo = managerRepo;
    }

    @Override
    public Manager saveManager(ManagerDTO managerDTO) {
        val managerSaved = managerRepo.save(new Manager(managerDTO));
        return managerSaved;
    }
}
