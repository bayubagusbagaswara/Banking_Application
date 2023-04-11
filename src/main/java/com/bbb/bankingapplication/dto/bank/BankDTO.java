package com.bbb.bankingapplication.dto.bank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankDTO {

    private String id;

    private String bankCode;

    private String areaCode;

    private String bankName;

    private String bankNetwork;

    private String bankShortName;

    private String biFastCode;

    private String ordering;

    private String rtgsCode;

    private String sknCode;

    private String swiftCode;

    private Instant createdAt;

    private Instant updatedAt;

    private String createdBy;

    private String updatedBy;

}
