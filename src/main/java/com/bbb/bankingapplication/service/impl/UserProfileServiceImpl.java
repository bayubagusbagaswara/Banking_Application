package com.bbb.bankingapplication.service.impl;

import com.bbb.bankingapplication.dto.CreateUserProfileRequest;
import com.bbb.bankingapplication.dto.CreateUserProfileResponse;
import com.bbb.bankingapplication.dto.GetUserDataRequest;
import com.bbb.bankingapplication.dto.UserInformationDTO;
import com.bbb.bankingapplication.model.enumerator.Language;
import com.bbb.bankingapplication.model.user.UserInformation;
import com.bbb.bankingapplication.model.user.UserProfile;
import com.bbb.bankingapplication.repository.UserInformationRepository;
import com.bbb.bankingapplication.repository.UserProfileRepository;
import com.bbb.bankingapplication.service.UserProfileService;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository userProfileRepository;
    private final UserInformationRepository userInformationRepository;

    public UserProfileServiceImpl(UserProfileRepository userProfileRepository, UserInformationRepository userInformationRepository) {
        this.userProfileRepository = userProfileRepository;
        this.userInformationRepository = userInformationRepository;
    }

    @Override
    public CreateUserProfileResponse createUserProfile(CreateUserProfileRequest request) {
        UserProfile userProfile = UserProfile.builder()
                .cif(request.getCif())
                .email(request.getEmail())
                .nameAlias(request.getNameAlias())
                .phoneNumber(request.getPhoneNumber())
                .build();

        Language language = Language.valueOf(request.getLanguage().toUpperCase());
        userProfile.setLanguage(language);

        Instant now = Instant.now();
        userProfile.setCreatedAt(now);
        userProfile.setUpdatedAt(now);

        userProfileRepository.save(userProfile);

        return CreateUserProfileResponse.builder()
                .id(userProfile.getId())
                .cif(userProfile.getCif())
                .email(userProfile.getEmail())
                .language(userProfile.getLanguage().name())
                .nameAlias(userProfile.getNameAlias())
                .phoneNumber(userProfile.getPhoneNumber())
                .createdAt(userProfile.getCreatedAt())
                .updatedAt(userProfile.getUpdatedAt())
                .build();
    }

    @Override
    public UserInformationDTO getAdminProfileById(GetUserDataRequest request) {
        UserProfile userProfile = userProfileRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("User Profile not found with id : [" + request.getId() + "]"));

        UserInformation userInformation = userInformationRepository.findByUserProfile(userProfile)
                .orElseThrow(() -> new RuntimeException("User Information not found"));

        return UserInformationDTO.builder()
                .fullName(userInformation.getFullName())
                .gender(userInformation.getGender())
                .build();
    }


}
