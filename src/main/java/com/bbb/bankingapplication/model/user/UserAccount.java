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
    private String accountNumber; // no rekening

    @Column(name = "account_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus; // active or deactivated

    @Column(name = "product_name")
    private String productName; // nama produk, misal Easy Wadiah memiliki banyak tipe

    @Column(name = "product_type")
    private String productType; // jenis produk

    @Column(name = "product_code")
    private String productCode; // code produk

    private String currencyCode; // mata uang yang digunakn untuk produk
}
