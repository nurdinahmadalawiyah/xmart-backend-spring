package com.xmart.xmartbackendspring.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class BarangResponseDto {
    String rfid;
    String namaBarang;
    BigDecimal hargaSatuan;
}
