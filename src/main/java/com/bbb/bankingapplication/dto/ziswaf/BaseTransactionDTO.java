package com.bbb.bankingapplication.dto.ziswaf;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BaseTransactionDTO {
    private String transactionDescription;
}
