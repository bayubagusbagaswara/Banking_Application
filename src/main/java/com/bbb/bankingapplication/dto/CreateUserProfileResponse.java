package com.bbb.bankingapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserProfileResponse {

    private Long id;

    private String cif;

    private String email;

    private String language;

    private String nameAlias;

    private String phoneNumber;

    private Instant createdAt;

    private Instant updatedAt;

    private String createdBy;

    private String updatedBy;

}
