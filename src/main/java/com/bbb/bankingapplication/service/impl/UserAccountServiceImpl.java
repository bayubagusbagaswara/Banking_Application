package com.bbb.bankingapplication.service.impl;

import com.bbb.bankingapplication.dto.CreateUserAccountRequest;
import com.bbb.bankingapplication.dto.CreateUserAccountResponse;
import com.bbb.bankingapplication.dto.UserAccountDTO;
import com.bbb.bankingapplication.model.enumerator.AccountStatus;
import com.bbb.bankingapplication.model.user.UserAccount;
import com.bbb.bankingapplication.model.user.UserProfile;
import com.bbb.bankingapplication.repository.UserAccountRepository;
import com.bbb.bankingapplication.repository.UserProfileRepository;
import com.bbb.bankingapplication.service.UserAccountService;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository userAccountRepository;
    private final UserProfileRepository userProfileRepository;

    public UserAccountServiceImpl(UserAccountRepository userAccountRepository, UserProfileRepository userProfileRepository) {
        this.userAccountRepository = userAccountRepository;
        this.userProfileRepository = userProfileRepository;
    }

    @Override
    public CreateUserAccountResponse createUserAccount(Long userProfileId, CreateUserAccountRequest request) {
        UserProfile userProfile = userProfileRepository.findById(userProfileId)
                .orElseThrow(() -> new RuntimeException("User profile not found with id : [" + userProfileId + "]"));

        UserAccount userAccount = UserAccount.builder()
                .userProfile(userProfile)
                .accountNumber(request.getAccountNumber())
                .productCode(request.getProductCode())
                .productName(request.getProductName())
                .currencyCode(request.getCurrencyCode())
                .build();

        AccountStatus accountStatus = AccountStatus.valueOf(request.getAccountStatus().toUpperCase());
        userAccount.setAccountStatus(accountStatus);

        Instant now = Instant.now();
        userAccount.setCreatedAt(now);
        userAccount.setUpdatedAt(now);

        userAccountRepository.save(userAccount);

        return CreateUserAccountResponse.builder()
                .id(String.valueOf(userAccount.getId()))
                .userProfileId(String.valueOf(userAccount.getUserProfile().getId()))
                .accountNumber(userAccount.getAccountNumber())
                .accountStatus(userAccount.getAccountStatus().name())
                .productName(userAccount.getProductName())
                .productCode(userAccount.getProductCode())
                .currencyCode(userAccount.getCurrencyCode())
                .createdAt(userAccount.getCreatedAt())
                .updatedAt(userAccount.getUpdatedAt())
                .build();
    }

    @Override
    public UserAccountDTO getUserAccountById(Long userAccountId) {
        UserAccount userAccount = userAccountRepository.findById(userAccountId)
                .orElseThrow(() -> new RuntimeException("User Account not found with id : [" + userAccountId + "]"));
        return mapToUserAccountDTO(userAccount);
    }

    private static UserAccountDTO mapToUserAccountDTO(UserAccount userAccount) {
        return UserAccountDTO.builder()
                .id(String.valueOf(userAccount.getId()))
                .userProfileId(String.valueOf(userAccount.getUserProfile().getId()))
                .accountNumber(userAccount.getAccountNumber())
                .accountStatus(userAccount.getAccountStatus().name())
                .productCode(userAccount.getProductCode())
                .productName(userAccount.getProductName())
                .currencyCode(userAccount.getCurrencyCode())
                .createdAt(userAccount.getCreatedAt())
                .updatedAt(userAccount.getUpdatedAt())
                .createdBy(userAccount.getCreatedBy())
                .updatedBy(userAccount.getUpdatedBy())
                .build();
    }

}
