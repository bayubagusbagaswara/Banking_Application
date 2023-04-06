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
@Table(name = "account_product")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountProduct extends UserAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_code")
    private String productCode;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_info")
    private String productInfo;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "product_short_description")
    private String productShortDescription;

    @Column(name = "minimum_balance")
    private BigDecimal minimumBalance; // minimum saldo tertahan

    @Column(name = "minimum_initial_deposit")
    private String minimumInitialDeposit; // minimum deposit untuk product ini (skip)

    @Column(name = "product_feature")
    private String productFeature;

//    private String productNameCard;
//    private String descriptionCard;
//    private String shortDescriptionCard;
}