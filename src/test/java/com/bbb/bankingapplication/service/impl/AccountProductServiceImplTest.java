package com.bbb.bankingapplication.service.impl;

import com.bbb.bankingapplication.dto.AccountProductDTO;
import com.bbb.bankingapplication.dto.CreateAccountProductRequest;
import com.bbb.bankingapplication.service.AccountProductService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class AccountProductServiceImplTest {

    @Autowired
    AccountProductService accountProductService;

    @Test
    void saveAccountProduct() {
        CreateAccountProductRequest request = CreateAccountProductRequest.builder()
                .productCodeNumber("6001")
                .productCodeName("EASY_WADIAH")
                .productTitle("Easy Wadiah")
                .productDescription("Jaga harta kamu tetap murni dengan prinsip tanpa riba")
                .productShortDescription("Bebas biaya administrasi bulanan. Fasilitas Kartu GPN & Visa. Gratis tarik tunai diseluruh ATM BSI & ATM Mandiri. Bebas biaya transaksi diseluruh EDC Bank Mandiri, Bank Indonesia, dan EDC Berlogo Prima.")
                .minimumBalance(new BigDecimal(20000))
                .minimumInitialDeposit(new BigDecimal(50000))
                .build();

        AccountProductDTO response = accountProductService.saveAccountProduct(request);

        assertNotNull(response.getId());
        log.info("Response : {}", response.toString());
    }

    @Test
    void getAccountProductByCodeName() {
        String productCodeName = "EASY_WADIAH";
        AccountProductDTO response = accountProductService.getAccountProductByCodeName(productCodeName);

        log.info("Balance: {}", response.getMinimumBalance()); // 20000.00
    }

    @Test
    void getAccountProductByCodeNumber() {

    }

    @Test
    void updateAccountProduct() {
    }

    @Test
    void deleteAccountProduct() {
    }
}