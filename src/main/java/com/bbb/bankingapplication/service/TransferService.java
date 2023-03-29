package com.bbb.bankingapplication.service;

import java.math.BigDecimal;

public interface TransferService {

    // fromAccount, toAccount, amount
    void transfer(Long fromAccountId, Long toAccountId, BigDecimal amount);
}
