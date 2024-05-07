package com.xmart.xmartbackendspring.dtos;

import com.xmart.xmartbackendspring.models.Barang;
import com.xmart.xmartbackendspring.models.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class TransaksiResponseDto {
    Customer customer;
    Barang barang;
    BigDecimal hargaSatuan;
    Integer jumlah;
    Date tanggalJam;
}
