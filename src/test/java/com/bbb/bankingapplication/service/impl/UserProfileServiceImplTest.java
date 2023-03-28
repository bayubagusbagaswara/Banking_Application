package com.bbb.bankingapplication.service.impl;

import com.bbb.bankingapplication.dto.CreateUserProfileRequest;
import com.bbb.bankingapplication.dto.CreateUserProfileResponse;
import com.bbb.bankingapplication.service.UserProfileService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class UserProfileServiceImplTest {

    @Autowired
    UserProfileService userProfileService;

    @Test
    void createUserProfile() {
        CreateUserProfileRequest request = CreateUserProfileRequest.builder()
                .cif("221663")
                .email("bayu@mail.com")
                .nameAlias("Bayu12")
                // enum harus sesuai yang ada di data enumerator Language
                // dan otomatis akan di UpperCase
                .language("idn")
                .phoneNumber("082211211209")
                .build();

        CreateUserProfileResponse response = userProfileService.createUserProfile(request);

        assertNotNull(response.getId());

        log.info("ID : {}", response.getId());
        log.info("CIF : {}", response.getCif());
        log.info("Language : {}", response.getLanguage());
    }

}