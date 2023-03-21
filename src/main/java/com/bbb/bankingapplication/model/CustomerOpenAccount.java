package com.bbb.bankingapplication.model;

import com.bbb.bankingapplication.model.base.UserAudit;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * Data nasabah untuk pembukaan akun / rekening
 * Apa saja yang dibutuhkan untuk membukan akun nasabah
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "customer_open_account")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerOpenAccount extends UserAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "reference_number")
    private String referenceNumber;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "identification_type")
    private String identificationType;

    @Column(name = "identification_number")
    private String identificationNumber;

    @Column(name = "mobile_phone")
    private String mobilePhone;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "status")
    private int status;

    private Date dateOfBirth;

    private String fullName;

    private String branchCode;

}
