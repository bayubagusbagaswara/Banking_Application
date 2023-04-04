package com.bbb.bankingapplication.service.impl;

import com.bbb.bankingapplication.dto.CreateUserInformationRequest;
import com.bbb.bankingapplication.dto.CreateUserInformationResponse;
import com.bbb.bankingapplication.dto.UserInformationDTO;
import com.bbb.bankingapplication.repository.UserInformationRepository;
import com.bbb.bankingapplication.service.UserInformationService;
import org.springframework.stereotype.Service;

@Service
public class UserInformationServiceImpl implements UserInformationService {

    private final UserInformationRepository userInformationRepository;

    public UserInformationServiceImpl(UserInformationRepository userInformationRepository) {
        this.userInformationRepository = userInformationRepository;
    }

    @Override
    public CreateUserInformationResponse saveUserInformation(CreateUserInformationRequest request) {
        return null;
    }

    @Override
    public UserInformationDTO getUserInformationById(Long userInformationId) {
        return null;
    }
}
