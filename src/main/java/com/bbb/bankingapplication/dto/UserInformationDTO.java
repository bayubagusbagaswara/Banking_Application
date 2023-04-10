package com.bbb.bankingapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInformationDTO implements Serializable {

    private static final long serialVersionUID = -7405784032778915086L;

    private Long userProfileId;

    private String userId;

    private String fullName;
    private String shortName;
    private String gender;
    private String maritalStatus;
    private String placeOfBirth;
    private Date dateOfBirth;
    private String citizenship;
    private String residentType;
    private String address;
    private String subDistrict;
    private String city;
    private String province;
    private Long branchId;

    private String jobPosition;
    private String phoneHome;
    private String division;
    private String postalCode;
    private String religion;
    private String nik;

}
