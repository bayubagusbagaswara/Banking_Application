package com.bbb.bankingapplication.service;

import com.bbb.bankingapplication.dto.deposit.OpeningDepositRequest;
import com.bbb.bankingapplication.dto.deposit.OpeningDepositResponse;
import com.bbb.bankingapplication.dto.deposit.UpdateDepositRequest;
import com.bbb.bankingapplication.dto.deposit.UpdateDepositResponse;

public interface DepositService {

    // openingDeposit
    OpeningDepositResponse openingDeposit(OpeningDepositRequest request);

    // changeDeposit atau updateDeposit
    UpdateDepositResponse updateDeposit(UpdateDepositRequest request);

    // disbursementOfFounds (Pencairan Data)

    // get list deposit

    // get detail deposit


    // generateDataOpenDeposit (ini akan diparsing ke template)

    // receipt (kwitansi)
    // generateDataReceiptOpenDeposit

    // generateDataTransactionChange

    // generateDataReceiptChange
}
