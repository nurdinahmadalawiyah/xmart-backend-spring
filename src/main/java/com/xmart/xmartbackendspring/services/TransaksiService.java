package com.xmart.xmartbackendspring.services;

import com.xmart.xmartbackendspring.dtos.DataResponseDto;
import com.xmart.xmartbackendspring.dtos.TransaksiResponseDto;

public interface TransaksiService {
    DataResponseDto<TransaksiResponseDto> getAllTransaksi();
}
