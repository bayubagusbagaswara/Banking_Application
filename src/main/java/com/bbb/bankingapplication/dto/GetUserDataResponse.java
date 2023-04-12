package com.bbb.bankingapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetUserDataResponse {

    // DATA MODEL USER PROFILE
    private Long userProfileId;
    private String cif;
    private String email;
    private String language;
    private String nameAlias;
    private String phoneNumber;

    // DATA MODEL USER INFORMATION
}
