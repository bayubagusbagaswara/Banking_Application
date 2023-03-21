package com.bbb.bankingapplication.model.user;

import com.bbb.bankingapplication.model.base.UserAudit;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

/**
 * ini adalah akun (jenis tabungan) milik nasabah
 * Nasabah (user) bisa memilik banyak akun
 * Jadi ini adalah informasi tentang Akun / rekening yang dipilih nasabah
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
    private String accountNumber;

    @Column(name = "account_status", nullable = false)
    private Long accountStatus;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_type")
    private String productType;

    @Column(name = "product_code")
    private String productCode;

    private String currencyCode;
}
