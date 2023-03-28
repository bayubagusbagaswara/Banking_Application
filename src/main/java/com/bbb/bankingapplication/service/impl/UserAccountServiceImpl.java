package com.bbb.bankingapplication.service.impl;

import com.bbb.bankingapplication.dto.CreateUserAccountRequest;
import com.bbb.bankingapplication.dto.CreateUserAccountResponse;
import com.bbb.bankingapplication.repository.UserAccountRepository;
import com.bbb.bankingapplication.service.UserAccountService;
import org.springframework.stereotype.Service;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository userAccountRepository;

    public UserAccountServiceImpl(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    public CreateUserAccountResponse createUserAccount(CreateUserAccountRequest request) {
        return null;
    }

}
