package com.bbb.bankingapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetailTabunganDto {

    private String noDeposito;
    private String branchOffice;
    private String timePeriod;
    private String maturityDate;
    private String systemDeposito;
    private String nisbahBagiHasilNasabah;
    private String nisbahBagiHasilBank;
    private BigDecimal biayaMaterai;
    private BigDecimal depositoAmount;
    private String accountAlias;
    private String fromAccountOwnerName;
}
