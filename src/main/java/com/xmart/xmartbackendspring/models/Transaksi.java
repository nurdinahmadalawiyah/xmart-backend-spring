package com.xmart.xmartbackendspring.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "transaksi")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Transaksi implements Serializable {
    @EmbeddedId
    private TransaksiId id;

    @ManyToOne
    @JoinColumn(name = "qrcode", insertable = false, updatable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "rfid", insertable = false, updatable = false)
    private Barang barang;

    @Column(name = "harga_satuan")
    private BigDecimal hargaSatuan;

    @Column(name = "jumlah")
    private Integer jumlah;
}