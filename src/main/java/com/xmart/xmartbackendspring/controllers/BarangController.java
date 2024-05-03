package com.xmart.xmartbackendspring.controllers;

import com.xmart.xmartbackendspring.dtos.BarangResponseDto;
import com.xmart.xmartbackendspring.dtos.DataResponseDto;
import com.xmart.xmartbackendspring.services.BarangService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/barang")
public class BarangController {
    BarangService barangService;

    @Autowired
    public BarangController(BarangService barangService) {
        this.barangService = barangService;
    }

    @GetMapping()
    public ResponseEntity<DataResponseDto<BarangResponseDto>> getAllBarang() {
        return ResponseEntity.ok(barangService.getAllBarang());
    }

    @GetMapping("/{rfid}")
    public ResponseEntity<BarangResponseDto> detailBarang(@PathVariable String rfid) {
        try {
            return ResponseEntity.ok(barangService.getById(rfid));
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }
}
