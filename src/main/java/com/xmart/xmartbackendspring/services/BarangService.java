package com.xmart.xmartbackendspring.services;

import com.xmart.xmartbackendspring.dtos.BarangResponseDto;
import com.xmart.xmartbackendspring.dtos.DataResponseDto;

public interface BarangService {
    DataResponseDto<BarangResponseDto> getAllBarang();
    BarangResponseDto getById(String rfid);
}
