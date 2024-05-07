package com.xmart.xmartbackendspring.services;

import com.xmart.xmartbackendspring.dtos.DataResponseDto;
import com.xmart.xmartbackendspring.dtos.TransaksiResponseDto;
import com.xmart.xmartbackendspring.models.Transaksi;
import com.xmart.xmartbackendspring.repositories.TransaksiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransaksiServiceImpl implements TransaksiService {
    TransaksiRepository transaksiRepository;

    @Autowired
    public TransaksiServiceImpl(TransaksiRepository transaksiRepository) {
        this.transaksiRepository = transaksiRepository;
    }

    @Override
    public DataResponseDto<TransaksiResponseDto> getAllTransaksi() {
        List<Transaksi> transaksiList = transaksiRepository.findAll();

        List<TransaksiResponseDto> dataList = transaksiList.stream()
                .map(transaksi -> TransaksiResponseDto.builder()
                        .customer(transaksi.getCustomer())
                        .barang(transaksi.getBarang())
                        .hargaSatuan(transaksi.getHargaSatuan())
                        .jumlah(transaksi.getJumlah())
                        .tanggalJam(transaksi.getId().getTanggalJam())
                        .build()
                ).toList();

        return DataResponseDto.<TransaksiResponseDto>builder()
                .data(dataList)
                .build();
    }
}
