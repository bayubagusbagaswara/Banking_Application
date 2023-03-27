package com.bbb.bankingapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInformationDTO implements Serializable {

    private static final long serialVersionUID = -7405784032778915086L;

    private Long userProfileId;

    private String userId;

    private String fullName;

    private String gender;

    private String citizenship;

    private String birthDate;

    private String birthPlace;


}
