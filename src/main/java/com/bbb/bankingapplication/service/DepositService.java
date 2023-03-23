package com.bbb.bankingapplication.service;

import com.bbb.bankingapplication.dto.OpeningDepositRequest;
import com.bbb.bankingapplication.dto.OpeningDepositResponse;

public interface DepositService {

    // openingDeposit
    OpeningDepositResponse openingDeposit(OpeningDepositRequest request);

    // changeDeposit

    // disbursementOfFounds (Pencairan Data)

    // get list deposit

    // get detail deposit


    // generateDataOpenDeposit (ini akan diparsing ke template)

    // receipt (kwitansi)
    // generateDataReceiptOpenDeposit

    // generateDataTransactionChange

    // generateDataReceiptChange
}
