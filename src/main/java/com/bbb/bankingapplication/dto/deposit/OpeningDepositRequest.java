package com.bbb.bankingapplication.dto.deposit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OpeningDepositRequest implements Serializable {

    private static final long serialVersionUID = -3014706647039717878L;

    @NotBlank(message = "M-PIN must not be blank")
    private String mPin;

    @NotBlank(message = "Product Code must not be blank")
    private String productCode;

    private String systemDeposit;
    private String depositPurpose;
    private Long productId;

    private String currency; // IDR, USD

    private String branchCode; // kode cabang
    private String eventCode;
    private String referralCode;
    private int accountIndex;

    private BigDecimal depositAmount;

    private Integer timePeriod; // 6 bulan atau 9 bulan

}
