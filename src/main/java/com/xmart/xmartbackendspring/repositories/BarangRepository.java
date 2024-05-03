package com.xmart.xmartbackendspring.repositories;

import com.xmart.xmartbackendspring.models.Barang;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarangRepository extends JpaRepository<Barang, String> {
}
