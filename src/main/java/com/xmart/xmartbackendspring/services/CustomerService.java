package com.xmart.xmartbackendspring.services;

import com.xmart.xmartbackendspring.dtos.CustomerResponseDto;
import com.xmart.xmartbackendspring.dtos.DataResponseDto;

public interface CustomerService {
    DataResponseDto<CustomerResponseDto> getAllCustomer();
    CustomerResponseDto getById(String qrcode);
}
