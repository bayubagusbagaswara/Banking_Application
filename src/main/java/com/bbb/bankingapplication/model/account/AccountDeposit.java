package com.bbb.bankingapplication.model.account;

import com.bbb.bankingapplication.model.base.UserAudit;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Ini adalah akun user untuk deposit
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "account_deposit_user")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountDeposit extends UserAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "disbursement_of_fund")
    private boolean disbursementOfFund; // pencairan dana

    @Column(name = "system_deposit")
    private String systemDeposit;

    @Column(name = "deposit_purpose")
    private String depositPurpose;

    @Column(name = "interest_liquid_acct")
    private String interestLiquidAcct;

    @Column(name = "maturity_date")
    private LocalDateTime maturityDate; // tanggal jatuh tempo

    private String depositId;

    private String automaticRollOverOption; // perpanjangan deposit otomatis

    private String mudBilyet;

    private String positionType;

    private String currency;

    private String coCode;

    private String maturityInstrument;

    private String terminal;

    private String struct;

    private String depositNumber;

    private String repayAccount;

    private String nominatedAccount;

    private String branchCode;

    private String branchName;

    private int accountIndex;

    private String cif;
}
