package com.bbb.bankingapplication.service;

import com.bbb.bankingapplication.dto.CreateUserAccountRequest;
import com.bbb.bankingapplication.dto.CreateUserAccountResponse;
import com.bbb.bankingapplication.dto.UserAccountDTO;

public interface UserAccountService {

    // cari user profile dulu
    // if("00".equals(..string..)) atau pengecekan untuk konstanta itu paling kiri, sedangkan variable di kanan

    // ini membuat rekening
    CreateUserAccountResponse createUserAccount(Long userProfileId, CreateUserAccountRequest request);

    UserAccountDTO getUserAccountById(Long userAccountId);


}
