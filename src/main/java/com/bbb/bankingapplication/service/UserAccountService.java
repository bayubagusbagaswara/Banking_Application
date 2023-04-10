package com.bbb.bankingapplication.service;

import com.bbb.bankingapplication.dto.CreateUserAccountRequest;
import com.bbb.bankingapplication.dto.CreateUserAccountResponse;
import com.bbb.bankingapplication.dto.UserAccountDTO;

/**
 * dinisi User akan memilik AccountProduct mana yang ingin digunakan sebagai rekeningnya
 * makanya dia akan get accountProduct untuk mendapatkan productName, productCode
 */
public interface UserAccountService {


    // ini membuat rekening
    CreateUserAccountResponse createUserAccount(Long userProfileId, CreateUserAccountRequest request);

    UserAccountDTO getUserAccountById(Long userAccountId);


}
