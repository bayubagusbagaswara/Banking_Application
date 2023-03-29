package com.bbb.bankingapplication.dto.deposit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepositDetailDTO {

    private String depositNumber;

    private String branchOffice;

    private String timePeriod;

    private String maturityDate;

    private String systemDeposit;

    private String nisbahBagiHasilNasabah;

    private String nisbahBagiHasilBank;

    private BigDecimal biayaMaterai; // stampDuty

    private BigDecimal depositAmount;

    private String accountAlias;

    private String fromAccountOwnerName;

    private String depositNameProduct;

    private String bilyet;

    private BigDecimal efektifBagiHasil;

}
