package com.bbb.bankingapplication.model.user;

import com.bbb.bankingapplication.model.base.UserAudit;
import com.bbb.bankingapplication.model.enumerator.AccountStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * ini adalah akun (jenis tabungan) milik nasabah
 * Nasabah (user) bisa memilik banyak akun
 * Jadi ini adalah informasi tentang Akun / rekening yang dipilih nasabah
 * Disinilah user akan pertama kali mendapatkan no rekening (account number)
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "user_account")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAccount extends UserAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_profile_id", referencedColumnName = "id")
    private UserProfile userProfile;

    @Column(name = "account_number", nullable = false)
    private String accountNumber; // nomor rekening

    @Column(name = "account_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus; // active or deactivated

    @Column(name = "product_name")
    private String productName; // nama produk, misal Easy Wadiah memiliki banyak tipe

    @Column(name = "product_code")
    private String productCode; // code produk rekening

    @Column(name = "currency_code")
    private String currencyCode; // mata uang yang digunakan untuk produk rekening

    @Column(name = "balance_total")
    private BigDecimal balanceTotal; // 100000.00

    @Column(name = "balance_total_formatted")
    private String balanceTotalFormatted; // 100.000,00

    // di sini ada field AdditionalData
    // dimana di AdditionalData ada info tentang balance (saldo)
    // berarti harus nambah sendiri
    // karena mungkin masalah pengurangan dan penambahan nominal terjadi di ESB

//    {
//        "balanceTotal": 100000.00,
//            "balanceTotalFormatted": "100.000,00",
//            "balanceAvailable": 50000.00,
//            "balanceAvailableFormatted": "50.000,00",
//            "balanceHold": 50000.00,
//            "balanceHoldFormatted": "50.000,00",
//            "rate": "1",
//            "accountNumber": "7420619175",
//            "accountNumberMasked": "******9175",
//            "currencyCode": "IDR",
//            "accountStatus": "Active",
//            "accountType": "SA",
//            "accountAlias": "Easy Mudharabah",
//            "isVisible": false,
//            "isSof": true,
//            "sofAllowed": true,
//            "productName": "Easy Mudharabah",
//            "accountCategory": "6010",
//            "accountOwnerName": "TRI PRIYANI RETNOWATI"
//    }
//{
//    "originalBalance": 10000000.00,
//        "originalBalanceFormatted": "10.000.000,00",
//        "rate": 1,
//        "maturityDate": "20160721",
//        "termCode": "06M",
//        "minimumAmount": 0.00,
//        "autoRenewal": true,
//        "accountNumber": "7000000132286487",
//        "accountNumberMasked": "************6487",
//        "currencyCode": "IDR",
//        "accountStatus": "Active",
//        "accountType": "CD",
//        "accountAlias": "Deposito",
//        "isVisible": false,
//        "isSof": false,
//        "sofAllowed": false,
//        "productName": "Deposito",
//        "accountCategory": "6601",
//        "accountOwnerName": "TRI PRIYANI RETNOWATI"
//}
}
