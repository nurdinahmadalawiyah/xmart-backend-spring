package com.xmart.xmartbackendspring.controllers;

import com.xmart.xmartbackendspring.dtos.DataResponseDto;
import com.xmart.xmartbackendspring.dtos.TransaksiResponseDto;
import com.xmart.xmartbackendspring.services.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaksi")
@CrossOrigin(origins = "*")
public class TransaksiController {
    TransaksiService transaksiService;

    @Autowired
    public TransaksiController(TransaksiService transaksiService) {
        this.transaksiService = transaksiService;
    }

    @GetMapping()
    public ResponseEntity<DataResponseDto<TransaksiResponseDto>> getAllTransaksi() {
        return ResponseEntity.ok(transaksiService.getAllTransaksi());
    }
}
