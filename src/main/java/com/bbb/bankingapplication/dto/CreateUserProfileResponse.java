package com.bbb.bankingapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
