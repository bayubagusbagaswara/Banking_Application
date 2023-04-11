package com.bbb.bankingapplication.service;

import com.bbb.bankingapplication.dto.AccountProductDTO;
import com.bbb.bankingapplication.dto.CreateAccountProductRequest;
import com.bbb.bankingapplication.dto.UpdateAccountProductRequest;

/**
 * Contoh AccountProduct adalah TabunganKu, Easy Wadiah, Easy Mudharabah
 * utama disini adalah untuk get (mengambil data Product rekening)
 * misal user memilih membuat account(rekening) dengan product Easy Wadiah
 * jadi kita ambil data Easy Wadiah, kita masukkan ke User
 * data AccountProduct ini dibutuhkan saat user ingin membuat akun/rekening atau UserAccount
 */
public interface AccountProductService {

    AccountProductDTO saveAccountProduct(CreateAccountProductRequest request);

    AccountProductDTO getAccountProductByCodeName(String productCodeName);

    AccountProductDTO getAccountProductByCodeNumber(String productCodeNumber);

    AccountProductDTO updateAccountProduct(String productCodeNumber, UpdateAccountProductRequest request);

    void deleteAccountProduct(String productCodeNumber);
}
