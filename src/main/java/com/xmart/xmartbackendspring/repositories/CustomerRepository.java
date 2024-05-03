package com.xmart.xmartbackendspring.repositories;

import com.xmart.xmartbackendspring.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
