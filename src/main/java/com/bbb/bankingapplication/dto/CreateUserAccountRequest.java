package com.bbb.bankingapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserAccountRequest {

    private String accountNumber;

    private String accountStatus;

    private String productType;

    private String productCode;

    private String currencyCode;
}
