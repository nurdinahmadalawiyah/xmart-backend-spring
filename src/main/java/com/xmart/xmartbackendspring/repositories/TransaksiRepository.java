package com.xmart.xmartbackendspring.repositories;

import com.xmart.xmartbackendspring.models.Transaksi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransaksiRepository extends JpaRepository<Transaksi, String> {
}
