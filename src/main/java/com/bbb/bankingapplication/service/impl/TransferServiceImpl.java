package com.bbb.bankingapplication.service.impl;

import com.bbb.bankingapplication.repository.TransactionHistoryRepository;
import com.bbb.bankingapplication.repository.UserAccountRepository;
import com.bbb.bankingapplication.repository.UserProfileRepository;
import com.bbb.bankingapplication.service.TransferService;
import org.springframework.stereotype.Service;

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

    // userProfile
    // userAccount
    // transactionHistory
}
