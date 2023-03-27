package com.bbb.bankingapplication.service;

import com.bbb.bankingapplication.dto.CreateUserProfileRequest;
import com.bbb.bankingapplication.dto.CreateUserProfileResponse;
import com.bbb.bankingapplication.dto.GetUserDataRequest;
import com.bbb.bankingapplication.dto.UserInformationDTO;

public interface UserProfileService {

    // create UserProfile
    CreateUserProfileResponse createUserProfile(CreateUserProfileRequest request);

    // get admin profile by id
    UserInformationDTO getAdminProfileById(GetUserDataRequest request);

    // update user info

    // validate account

    // get all user setting

    // get user profile by cif

    // get user by username

    // get user by id

    // update user profile

    // create account form opening
}
