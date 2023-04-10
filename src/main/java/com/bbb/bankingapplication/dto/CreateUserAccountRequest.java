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

    private String accountStatus; // secara default saat request pasti accountStatus ini belum active

    private String productCode; // didapat dari AccountProduct

    private String productName; // didapat dari AccountProduct

    private String currencyCode; // user memilih tabungannya dalam mata uang apa
}
