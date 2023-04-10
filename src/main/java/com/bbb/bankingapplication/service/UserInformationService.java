package com.bbb.bankingapplication.service;

import com.bbb.bankingapplication.dto.CreateUserInformationRequest;
import com.bbb.bankingapplication.dto.UserInformationDTO;

public interface UserInformationService {

    UserInformationDTO saveUserInformation(CreateUserInformationRequest request);

    UserInformationDTO getUserInformationById(Long userInformationId);
}
