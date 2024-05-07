package com.xmart.xmartbackendspring.models;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransaksiId implements Serializable {
    private String qrcode;
    private String rfid;
    private Date tanggalJam;
}
