package com.bbb.bankingapplication.service.impl;

import com.bbb.bankingapplication.dto.CreateUserInformationResponse;
import com.bbb.bankingapplication.repository.UserInformationRepository;
import com.bbb.bankingapplication.service.UserInformationService;
import org.springframework.stereotype.Service;

@Service
public class UserInformationServiceImpl implements UserInformationService {

    private final UserInformationRepository userInformationRepository;

    public UserInformationServiceImpl(UserInformationRepository userInformationRepository) {
        this.userInformationRepository = userInformationRepository;
    }
}
