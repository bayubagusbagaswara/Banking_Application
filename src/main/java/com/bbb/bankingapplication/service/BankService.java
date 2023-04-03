package com.bbb.bankingapplication.service;

import com.bbb.bankingapplication.dto.bank.*;

import java.util.List;

public interface BankService {

    // create bank
    CreateBankResponse saveBank(CreateBankRequest request);

    // get bank
    BankDTO getBankById(Long id);

    // get bank by code
    BankDTO getBankByCode(String bankCode);

    // get bank by swift code
    BankDTO getBankBySwiftCode(String swiftCode);

    // get list bank
    List<BankDTO> getAllBankList();

    // update bank
    UpdateBankResponse updateBank(Long bankId, UpdateBankRequest request);

    // delete bank
    void deleteBank(Long bankId);

    // update bulk online switching ini delete semua lalu buat lagi dari awal
    // service ini untuk membuat bank list sekaligus, tidak satu per satu
    //

}
