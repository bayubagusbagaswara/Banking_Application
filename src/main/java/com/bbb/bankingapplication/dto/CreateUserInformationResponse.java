package com.bbb.bankingapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserInformationResponse {

    private String id;

    private String userProfileId;

    private String fullName;

    private String shortName;

    private String gender;

    private String maritalStatus;

    private String placeOfBirth;

    private Date dateOfBirth;

    private String citizenship;

    private String residentType;

    private String referralCode;

    private String address;

    private String subDistrict;

    private String city;

    private String province;

    private String branchId;

    private String jobPosition;

    private String cardNumberId;

    private String phoneNumber;

    private String division;

    private String postalCode;

    private String religion;

    private String nik;
}
