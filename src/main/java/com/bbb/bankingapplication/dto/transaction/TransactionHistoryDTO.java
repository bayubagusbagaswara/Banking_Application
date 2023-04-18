package com.bbb.bankingapplication.dto.transaction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionHistoryDTO {

    private String id;

    private String transactionCategory;

    private String transactionDescription;
}
