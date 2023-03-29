package com.bbb.bankingapplication.service.impl;

import com.bbb.bankingapplication.repository.BankRepository;
import com.bbb.bankingapplication.service.BankService;
import org.springframework.stereotype.Service;

@Service
public class BankServiceImpl implements BankService {

    private final BankRepository bankRepository;

    public BankServiceImpl(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }
}
