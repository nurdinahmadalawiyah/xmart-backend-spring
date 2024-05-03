package com.xmart.xmartbackendspring.services;

import com.xmart.xmartbackendspring.dtos.CustomerResponseDto;
import com.xmart.xmartbackendspring.dtos.DataResponseDto;
import com.xmart.xmartbackendspring.models.Customer;
import com.xmart.xmartbackendspring.repositories.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public DataResponseDto<CustomerResponseDto> getAllCustomer() {
        List<Customer> customerList = customerRepository.findAll();

        List<CustomerResponseDto> dataList = customerList.stream()
                .map(customer -> CustomerResponseDto.builder()
                        .qrCode(customer.getQrCode())
                        .nama(customer.getNama())
                        .wallet(customer.getWallet())
                        .build()
                ).toList();

        return DataResponseDto.<CustomerResponseDto>builder()
                .data(dataList)
                .build();
    }

    @Override
    public CustomerResponseDto getById(String qrcode) {
        Customer customer = customerRepository.findById(qrcode)
                .orElseThrow(() -> new EntityNotFoundException("Customer with qr code " + qrcode + " not found"));

        return CustomerResponseDto.builder()
                .qrCode(customer.getQrCode())
                .nama(customer.getNama())
                .wallet(customer.getWallet())
                .build();
    }
}
