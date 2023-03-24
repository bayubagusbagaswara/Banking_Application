package com.bbb.bankingapplication.service.impl;

import com.bbb.bankingapplication.dto.GetUserDataRequest;
import com.bbb.bankingapplication.dto.UserProfileDTO;
import com.bbb.bankingapplication.model.user.UserInformation;
import com.bbb.bankingapplication.model.user.UserProfile;
import com.bbb.bankingapplication.repository.UserInformationRepository;
import com.bbb.bankingapplication.repository.UserProfileRepository;
import com.bbb.bankingapplication.service.UserProfileService;
import org.springframework.stereotype.Service;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository userProfileRepository;
    private final UserInformationRepository userInformationRepository;

    public UserProfileServiceImpl(UserProfileRepository userProfileRepository, UserInformationRepository userInformationRepository) {
        this.userProfileRepository = userProfileRepository;
        this.userInformationRepository = userInformationRepository;
    }

    @Override
    public UserProfileDTO getAdminProfileById(GetUserDataRequest request) {
        UserProfile userProfile = userProfileRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("User Profile not found with id : [" + request.getId() + "]"));

        UserInformation userInformation = userInformationRepository.findByUserProfile(userProfile)
                .orElseThrow(() -> new RuntimeException("User Information not found"));

        return UserProfileDTO.builder()
                .fullName(userInformation.getFullName())
                .gender(userInformation.getGender())
                .build();
    }


}
