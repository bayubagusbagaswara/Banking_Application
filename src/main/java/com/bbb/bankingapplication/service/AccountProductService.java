package com.bbb.bankingapplication.service;

import com.bbb.bankingapplication.dto.AccountProductDTO;
import com.bbb.bankingapplication.dto.CreateAccountProductRequest;

/**
 * Contoh AccountProduct adalah TabunganKu, Easy Wadiah, Easy Mudharabah
 * utama disini adalah untuk get (mengambil data Product rekening)
 * misal user memilih membuat account(rekening) dengan product Easy Wadiah
 * jadi kita ambil data Easy Wadiah, kita masukkan ke User
 */
public interface AccountProductService {

    // create AccountProduct
    AccountProductDTO saveAccountProduct(CreateAccountProductRequest request);

    AccountProductDTO getAccountProductByName(String productName);

    AccountProductDTO getAccountProductByCode(String productCode);

//    AccountProductDTO updateAccountProduct();
//
//    void deleteAccountProduct();
}
