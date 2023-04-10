package com.bbb.bankingapplication.service.impl;

import com.bbb.bankingapplication.dto.AccountProductDTO;
import com.bbb.bankingapplication.dto.CreateAccountProductRequest;
import com.bbb.bankingapplication.service.AccountProductService;
import org.springframework.stereotype.Service;

@Service
public class AccountProductServiceImpl implements AccountProductService {

    @Override
    public AccountProductDTO saveAccountProduct(CreateAccountProductRequest request) {
        return null;
    }

    @Override
    public AccountProductDTO getAccountProductByName(String productName) {
        return null;
    }

    @Override
    public AccountProductDTO getAccountProductByCode(String productCode) {
        return null;
    }
}
