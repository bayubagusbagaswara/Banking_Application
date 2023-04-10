package com.bbb.bankingapplication.service;

import com.bbb.bankingapplication.dto.AccountProductDTO;

public interface AccountProductService {

    // utama disini adalah untuk get (mengambil data Product rekening)
    // misal user memilih membuat account(rekening) dengan product Easy Wadiah
    // jadi kita ambil data Easy Wadiah, kita masukkan ke User

    AccountProductDTO getAccountProductByName(String productName);

    AccountProductDTO getAccountProductByCode(String productCode);
}
