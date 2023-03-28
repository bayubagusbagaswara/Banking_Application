package com.bbb.bankingapplication.service.impl;

import com.bbb.bankingapplication.dto.CreateUserAccountRequest;
import com.bbb.bankingapplication.dto.CreateUserAccountResponse;
import com.bbb.bankingapplication.service.UserAccountService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class UserAccountServiceImplTest {

    @Autowired
    UserAccountService userAccountService;

    @Test
    void createUserAccount() {
        // userProfile = Albert, ID = 1
        Long userProfileId = 1L;

        CreateUserAccountRequest request = CreateUserAccountRequest.builder()
                .accountNumber("77145995")
                .accountStatus("active")
                .productName("Easy Wadiah")
                .productCode("008")
                .productType("A")
                .currencyCode("IDR")
                .build();

        CreateUserAccountResponse userAccount = userAccountService.createUserAccount(userProfileId, request);

        assertNotNull(userAccount.getId());
        log.info("Account Number : {}", userAccount.getAccountNumber());
        log.info("Account Status : {}", userAccount.getAccountStatus());
    }
}