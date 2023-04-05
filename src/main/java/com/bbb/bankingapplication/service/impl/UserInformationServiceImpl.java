package com.bbb.bankingapplication.service.impl;

import com.bbb.bankingapplication.dto.CreateUserInformationRequest;
import com.bbb.bankingapplication.dto.CreateUserInformationResponse;
import com.bbb.bankingapplication.dto.UserInformationDTO;
import com.bbb.bankingapplication.model.user.UserInformation;
import com.bbb.bankingapplication.model.user.UserProfile;
import com.bbb.bankingapplication.repository.UserInformationRepository;
import com.bbb.bankingapplication.repository.UserProfileRepository;
import com.bbb.bankingapplication.service.UserInformationService;
import org.springframework.stereotype.Service;

@Service
public class UserInformationServiceImpl implements UserInformationService {

    private final UserInformationRepository userInformationRepository;
    private final UserProfileRepository userProfileRepository;

    public UserInformationServiceImpl(UserInformationRepository userInformationRepository, UserProfileRepository userProfileRepository) {
        this.userInformationRepository = userInformationRepository;
        this.userProfileRepository = userProfileRepository;
    }

    @Override
    public CreateUserInformationResponse saveUserInformation(CreateUserInformationRequest request) {
        // cari UserProfile by id dulu
        UserProfile userProfile = userProfileRepository.findById(Long.valueOf(request.getUserProfileId()))
                .orElseThrow(() -> new RuntimeException("User profile not found with id :[" + request.getUserProfileId() + "]"));

        UserInformation userInformation = UserInformation.builder()
                .build();

        userInformationRepository.save(userInformation);
        return null;
    }

    @Override
    public UserInformationDTO getUserInformationById(Long userInformationId) {
        return null;
    }


    private static CreateUserInformationResponse mapToCreateUserInformationResponse(UserInformation userInformation) {
        return null;
    }

    private static UserInformationDTO mapToUserInformationDTO(UserInformation userInformation) {
        return UserInformationDTO.builder()
                .userId(String.valueOf(userInformation.getId()))
                .userProfileId(userInformation.getUserProfile().getId())
                .fullName(userInformation.getFullName())
                .shortName(userInformation.getShortName())
                .gender(userInformation.getGender())
                .maritalStatus(userInformation.getMaritalStatus())
                .placeOfBirth(userInformation.getPlaceOfBirth())
                .dateOfBirth(userInformation.getDateOfBirth())
                .citizenship(userInformation.getCitizenship())
                .residentType(userInformation.getResidentType())
                .address(userInformation.getAddress())
                .subDistrict(userInformation.getSubDistrict())
                .city(userInformation.getCity())
                .province(userInformation.getProvince())
                .branchId(userInformation.getBranchId())
                .jobPosition(userInformation.getJobPosition())
                .phoneHome(userInformation.getPhoneHome())
                .division(userInformation.getDivision())
                .postalCode(userInformation.getPostalCode())
                .religion(userInformation.getReligion())
                .nik(userInformation.getNik())
                .build();
    }
}
