package com.bbb.bankingapplication.service;

import com.bbb.bankingapplication.dto.transfer.TransferRequestDTO;
import com.bbb.bankingapplication.dto.transfer.TransferResponseDTO;

import java.math.BigDecimal;

public interface TransferService {

    void transfer(Long fromAccountId, Long toAccountId, BigDecimal amount);

    TransferResponseDTO transferOnlineInquiry(TransferRequestDTO request);

    TransferResponseDTO transferOnline(TransferRequestDTO request);
}
