package com.xmart.xmartbackendspring.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "barang")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Barang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rfid")
    private String rfid;

    @Column(name = "nama_barang")
    private String namaBarang;

    @Column(name = "harga_satuan")
    private BigDecimal hargaSatuan;
}
