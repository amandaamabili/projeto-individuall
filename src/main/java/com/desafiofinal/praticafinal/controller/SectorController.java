package com.desafiofinal.praticafinal.controller;

import com.desafiofinal.praticafinal.dto.ProductDTO;
import com.desafiofinal.praticafinal.dto.SectorDTO;
import com.desafiofinal.praticafinal.dto.SellerDTO;
import com.desafiofinal.praticafinal.model.Product;
import com.desafiofinal.praticafinal.model.Sector;
import com.desafiofinal.praticafinal.service.ISectorservice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/fresh-products/sector")
public class SectorController {

    private ISectorservice sectorservice;

    public SectorController(ISectorservice sectorservice) {
        this.sectorservice = sectorservice;
    }

    /**
     * Route used to insert into the database a new sector
     * @param sectordto
     * @return HTML Response 201: Created
     */
    @PostMapping
    public ResponseEntity<Object> insertSector(@RequestBody @Valid SectorDTO sectordto){
        try{
            Sector response = sectorservice.saveSector(sectordto);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
