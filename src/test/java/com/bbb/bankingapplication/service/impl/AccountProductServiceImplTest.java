package com.bbb.bankingapplication.service.impl;

import com.bbb.bankingapplication.dto.AccountProductDTO;
import com.bbb.bankingapplication.dto.CreateAccountProductRequest;
import com.bbb.bankingapplication.service.AccountProductService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AccountProductServiceImplTest {

    @Autowired
    AccountProductService accountProductService;

    @Test
    @Order(1)
    void saveAccountProduct1() {
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
    void saveAccountProduct2() {
        CreateAccountProductRequest request = CreateAccountProductRequest.builder()
                .productCodeNumber("6002")
                .productCodeName("EASY_MUDHARABAH")
                .productTitle("Easy Mudharabah")
                .productDescription("Dapatkan keuntungan bagi hasil sesuai dengan prinsip syariah")
                .productShortDescription("Mendapatkan imbal hasil. Fasilitas Kartu GPN & Visa. Gratis tarik tunai diseluruh ATM BSI & ATM Mandiri. Bebas biaya transaksi diseluruh EDC Bank Mandiri, Bank Indonesia, dan EDC Berlogo Prima.")
                .minimumBalance(new BigDecimal(20000))
                .minimumInitialDeposit(new BigDecimal(50000))
                .build();

        AccountProductDTO response = accountProductService.saveAccountProduct(request);

        assertNotNull(response.getId());
        log.info("Response : {}", response.toString());
    }

    @Test
    void saveAccountProduct3() {
        CreateAccountProductRequest request = CreateAccountProductRequest.builder()
                .productCodeNumber("6003")
                .productCodeName("GADAI_EMAS")
                .productTitle("Gadai Emas Fisik")
                .productDescription("Fitur menggadai (Rahn) emas dari perhiasan, logam mulia atau koin emas/koin dinar")
                .productShortDescription("Nilai taksiran tinggi. Proses mudah dan depat. Emas tersimpan aman dan terjamin.")
                .minimumBalance(new BigDecimal(20000))
                .minimumInitialDeposit(new BigDecimal(50000))
                .build();

        AccountProductDTO response = accountProductService.saveAccountProduct(request);
        assertNotNull(response.getId());
        log.info("Response : {}", response.toString());
    }

    @Test
    @Order(4)
    void saveAccountProduct4() {
        CreateAccountProductRequest request = CreateAccountProductRequest.builder()
                .productCodeNumber("6004")
                .productCodeName("TABUNGAN_QURBAN")
                .productTitle("Tabungan Qurban")
                .productDescription("Mari berqurban untuk saling berbagi kebahagiaan bersama BSI")
                .productShortDescription("Atur nabung terjadwal kamu. Bisa setor diluar jadwal autodebet. Dapat memilih akad tabungan sesuai keinginan kamu. Bisa beli hewan qurban melalui rekening BSI ketika jatuh tempo.")
                .minimumBalance(new BigDecimal(20000))
                .minimumInitialDeposit(new BigDecimal(50000))
                .build();

        AccountProductDTO response = accountProductService.saveAccountProduct(request);
        assertNotNull(response.getId());
        log.info("Response : {}", response.toString());
    }

    @Test
    void saveAccountProduct5() {
        CreateAccountProductRequest request = CreateAccountProductRequest.builder()
                .productCodeNumber("6005")
                .productCodeName("CICIL_EMAS")
                .productTitle("Cicil Emas")
                .productDescription("Pembelian emas kualitas terbaik dengan cara dicicil")
                .productShortDescription("Emas 100% diasuransikan. Jangka waktu 1-5 tahun. Dapat diuangkan dengan cara digadaikan untuk kebutuhan mendesak")
                .minimumBalance(new BigDecimal(20000))
                .minimumInitialDeposit(new BigDecimal(50000))
                .build();

        AccountProductDTO response = accountProductService.saveAccountProduct(request);
        assertNotNull(response.getId());
        log.info("Response : {}", response.toString());
    }

    @Test
    void saveAccountProduct6() {
        CreateAccountProductRequest request = CreateAccountProductRequest.builder()
                .productCodeNumber("6006")
                .productCodeName("SBSN")
                .productTitle("SBSN")
                .productDescription("Simpanan investasi yang dijamin aman oleh Pemerintah. Yuk ikut berkontribusi kepada negara!")
                .productShortDescription("Aman dijamin pemerintah 100%. Menguntungkan dengan imbalan setiap bulan. Terjangkau dengan modal investasi minimum.")
                .minimumBalance(new BigDecimal(20000))
                .minimumInitialDeposit(new BigDecimal(50000))
                .build();

        AccountProductDTO response = accountProductService.saveAccountProduct(request);
        assertNotNull(response.getId());
        log.info("Response : {}", response.toString());
    }

    @Test
    void saveAccountProduct7() {
        CreateAccountProductRequest request = CreateAccountProductRequest.builder()
                .productCodeNumber("6007")
                .productCodeName("GRIYA_HASANAH")
                .productTitle("Griya Hasanah")
                .productDescription("Wujudkan memiliki rumah impian dengan langkah mudah untuk kebaikan kamu")
                .productShortDescription("Proses cepat dan mudah. Plafon mulai dari Rp 50 Juta s.d. Rp 1.5M. Jangka waktu s.d. 20 tahun.")
                .minimumBalance(new BigDecimal(20000))
                .minimumInitialDeposit(new BigDecimal(50000))
                .build();

        AccountProductDTO response = accountProductService.saveAccountProduct(request);
        assertNotNull(response.getId());
        log.info("Response : {}", response.toString());
    }

    @Test
    void saveAccountProduct8() {
        CreateAccountProductRequest request = CreateAccountProductRequest.builder()
                .productCodeNumber("6008")
                .productCodeName("TABUNGAN_HAJI_INDONESIA")
                .productTitle("Tabungan Haji Indonesia")
                .productDescription("Simpanan berjangka khusus untuk membantu menunaikan ibadah Haji dengan Akad Mudharabah Muthlaqah")
                .productShortDescription("Atur perencanaan ibadah haji kamu. Tanpa biaya bulanan. Pendaftaran & Pelunasan dapat dilakukan di BSI Mobile.")
                .minimumBalance(new BigDecimal(20000))
                .minimumInitialDeposit(new BigDecimal(50000))
                .build();

        AccountProductDTO response = accountProductService.saveAccountProduct(request);
        assertNotNull(response.getId());
        log.info("Response : {}", response.toString());
    }

    @Test
    void saveAccountProduct9() {
        CreateAccountProductRequest request = CreateAccountProductRequest
                .builder().build();

        AccountProductDTO response = accountProductService.saveAccountProduct(request);
        assertNotNull(response.getId());
        log.info("Response : {}", response);
    }

    @Test
    void getAccountProductByCodeName() {
        String productCodeName = "EASY_WADIAH";
        AccountProductDTO response = accountProductService.getAccountProductByCodeName(productCodeName);

        log.info("Balance: {}", response.getMinimumBalance()); // 20000.00
        log.info("Created At: {}", response.getCreatedAt()); // 2023-04-11T04:44:59.584555Z
    }

    @Test
    void getAccountProductByCodeNumber() {

        String productCodeNumber = "";


    }

    @Test
    void updateAccountProduct() {
    }

    @Test
    void deleteAccountProduct() {
    }
}