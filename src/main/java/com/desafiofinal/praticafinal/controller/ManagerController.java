package com.desafiofinal.praticafinal.controller;

import com.desafiofinal.praticafinal.dto.ManagerDTO;
import com.desafiofinal.praticafinal.service.IManagerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/fresh-products/manager")

public class ManagerController {

    private IManagerService managerService;

    public ManagerController(IManagerService managerService) {
        this.managerService = managerService;
    }

    /**
     * Route used to insert into the database a new manager
     * @param managerDTO
     * @return HTML Response 201: Created
     */
    @PostMapping
    public ResponseEntity<Object> insertManager(@RequestBody @Valid ManagerDTO managerDTO) {
        try{
            var response = managerService.saveManager(managerDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }


}
