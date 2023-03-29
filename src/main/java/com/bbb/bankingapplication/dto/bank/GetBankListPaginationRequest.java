package com.bbb.bankingapplication.dto.bank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetBankListPaginationRequest {

    private Integer pageSize;
    private Integer pageNumber;
    private String direction;
    private String sortBy;
    private String bankName;

    private String onlineSwitchingType;
    private Boolean onlineTransfer;
    private Boolean rtgsTransfer;
    private Boolean sknTransfer;
    private Boolean biFastTransfer;
    private Boolean isDeleted;
    private String onlineBankCode;
    private String swiftCode;

    //add new param
    private String bankShortName;
    private Integer ordering;
}
