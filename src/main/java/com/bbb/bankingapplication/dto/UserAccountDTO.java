package com.bbb.bankingapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAccountDTO {

    private String id;

    private String userProfileId;

    private String accountNumber;

    private String accountStatus;

    private String productName;

    private String productType;

    private String productCode;

    private String currencyCode;

    private BigDecimal balance;

    private String accountOwnerName;

    private Instant createdAt;
    private Instant updatedAt;

    private String createdBy;
    private String updatedBy;

//    @ApiModelProperty("Nomor kartu pada rekening ini")
//    private String cardNumber;
//    @ApiModelProperty("Status kartu pada rekening ini")
//    private String cardStatus;
//    @ApiModelProperty("Indeks pengurutan untuk rekening ini")
//    private Integer ordering;
//    @ApiModelProperty("Penentu rekening ini boleh ditampilkan")
//    private Boolean isVisible;
//    @ApiModelProperty("Penentu rekening ini sebagai sumber dana")
//    private Boolean isSof;
//    @ApiModelProperty("Informasi tambahan untuk rekening ini")
//    private String additionalData;
//    @ApiModelProperty("Aliasing untuk rekening ini")
//    private String accountAlias;
//    @ApiModelProperty("Jumlah saldo di rekening ini")
//    private BigDecimal balance;
//    @ApiModelProperty("Penentu rekening ini rekening utama")
//    private Boolean isPrimary;
//    @ApiModelProperty("Nama pemilik rekening")
//    private String accountOwnerName;
//    private String accountLinking;
//    private int accountIndex;
//    private Long userProfileId;
//    private String balanceFormatted;
}
