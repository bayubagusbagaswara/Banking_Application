package com.bbb.bankingapplication.model.product;

import com.bbb.bankingapplication.model.base.UserAudit;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Account Product adalah jenis-jenis produk rekening
 * misalnya Tabunganku, KaryawanPelajar
 * ini berfungsi sebagai Parameter, berbeda dengan AccountProduct dan AccountHaji
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "account_product", uniqueConstraints = {
        @UniqueConstraint(name = "product_code_number_unique", columnNames = "product_code_number"),
        @UniqueConstraint(name = "product_code_name_unique", columnNames = "product_code_name")
})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountProduct extends UserAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_code_number")
    private String productCodeNumber; // 6001

    @Column(name = "product_code_name")
    private String productCodeName; // EASY_WADIAH

    @Column(name = "product_title")
    private String productTitle; // Easy Wadiah

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "product_short_description")
    private String productShortDescription;

    @Column(name = "minimum_balance")
    private BigDecimal minimumBalance; // minimum saldo tertahan

    @Column(name = "minimum_initial_deposit")
    private BigDecimal minimumInitialDeposit; // minimum deposit awal untuk product ini (skip)

//    @Column(name = "product_feature")
//    private String productFeature; // fitur unggulan product (berbentuk poin-poin)

//    private String productNameCard;
//    private String descriptionCard;
//    private String shortDescriptionCard;
}
