package com.xmart.xmartbackendspring.services;

import com.xmart.xmartbackendspring.dtos.BarangResponseDto;
import com.xmart.xmartbackendspring.dtos.DataResponseDto;
import com.xmart.xmartbackendspring.models.Barang;
import com.xmart.xmartbackendspring.repositories.BarangRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BarangServiceImpl implements BarangService {
    BarangRepository barangRepository;

    @Autowired
    public BarangServiceImpl(BarangRepository barangRepository) {
        this.barangRepository = barangRepository;
    }

    @Override
    public DataResponseDto<BarangResponseDto> getAllBarang() {
        List<Barang> barangList = barangRepository.findAll();

        List<BarangResponseDto> dataList = barangList.stream()
                .map(barang -> BarangResponseDto.builder()
                        .rfid(barang.getRfid())
                        .namaBarang(barang.getNamaBarang())
                        .hargaSatuan(barang.getHargaSatuan())
                        .build()
                ).toList();

        return DataResponseDto.<BarangResponseDto>builder()
                .data(dataList)
                .build();
    }

    @Override
    public BarangResponseDto getById(String rfid) {
        Barang barang = barangRepository.findById(rfid)
                .orElseThrow(() -> new EntityNotFoundException("Barang with rfid " + rfid + " not found"));

        return BarangResponseDto.builder()
                .rfid(barang.getRfid())
                .namaBarang(barang.getNamaBarang())
                .hargaSatuan(barang.getHargaSatuan())
                .build();
    }
}
