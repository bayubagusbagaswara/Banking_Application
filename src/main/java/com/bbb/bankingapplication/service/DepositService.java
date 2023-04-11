package com.bbb.bankingapplication.service;

import com.bbb.bankingapplication.dto.deposit.OpeningDepositRequest;
import com.bbb.bankingapplication.dto.deposit.OpeningDepositResponse;
import com.bbb.bankingapplication.dto.deposit.UpdateDepositRequest;
import com.bbb.bankingapplication.dto.deposit.UpdateDepositResponse;

public interface DepositService {

    // nasabah membuka deposit
    OpeningDepositResponse openingDeposit(OpeningDepositRequest request);

    // update deposit dilakukan oleh
    // update deposit request cuma membawa data mpin, idDeposito, systemDeposito
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
