package com.bbb.bankingapplication.service.impl;

import com.bbb.bankingapplication.model.user.UserAccount;
import com.bbb.bankingapplication.repository.TransactionHistoryRepository;
import com.bbb.bankingapplication.repository.UserAccountRepository;
import com.bbb.bankingapplication.repository.UserProfileRepository;
import com.bbb.bankingapplication.service.TransferService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransferServiceImpl implements TransferService {

    private final UserProfileRepository userProfileRepository;
    private final UserAccountRepository userAccountRepository;
    private final TransactionHistoryRepository transactionHistoryRepository;

    public TransferServiceImpl(UserProfileRepository userProfileRepository, UserAccountRepository userAccountRepository, TransactionHistoryRepository transactionHistoryRepository) {
        this.userProfileRepository = userProfileRepository;
        this.userAccountRepository = userAccountRepository;
        this.transactionHistoryRepository = transactionHistoryRepository;
    }

    @Override
    public void transfer(Long fromAccountId, Long toAccountId, BigDecimal amount) {
        // cari account formAccount by id
        UserAccount fromAccount = userAccountRepository.findById(fromAccountId)
                .orElseThrow(() -> new RuntimeException("From Account not found with id : [" + fromAccountId + "]"));

        // cari account toAccount by id
        UserAccount toAccount = userAccountRepository.findById(toAccountId)
                .orElseThrow(() -> new RuntimeException("To Account not found with id : [" + toAccountId + "]"));

        // tambahkan saldo toAccount dan kurangi saldo fromAccount

        // simpan transaction di TransactionHistory untuk fromAccount dan toAccount



    }

    // userProfile
    // userAccount
    // transactionHistory
}
