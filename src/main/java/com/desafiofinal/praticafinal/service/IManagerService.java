package com.desafiofinal.praticafinal.service;

import com.desafiofinal.praticafinal.dto.ManagerDTO;
import com.desafiofinal.praticafinal.model.Manager;

public interface IManagerService {
    Manager saveManager(ManagerDTO managerDTO);
}
