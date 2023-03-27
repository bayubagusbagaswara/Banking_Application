package com.bbb.bankingapplication.model.transaction;

import com.bbb.bankingapplication.model.base.UserAudit;
import com.bbb.bankingapplication.model.enumerator.TransactionCategory;
import com.bbb.bankingapplication.model.enumerator.TransactionCurrency;
import com.bbb.bankingapplication.model.enumerator.TransactionState;
import com.bbb.bankingapplication.model.enumerator.TransactionStatus;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Information about Transaction History customer
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "transaction_history")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionHistory extends UserAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_profile_id", nullable = false)
    private Long userProfileId;

    @Column(name = "transaction_category")
    @Enumerated(EnumType.STRING)
    private TransactionCategory transactionCategory;

    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "transaction_description")
    private String transactionDescription;

    @Column(name = "transaction_date")
    private Date transactionDate;

    @Column(name = "transaction_status")
    @Enumerated(EnumType.ORDINAL)
    private TransactionStatus transactionStatus;

    @Column(name = "transaction_currency")
    @Enumerated(EnumType.STRING)
    private TransactionCurrency transactionCurrency;

    @Column(name = "transaction_amount")
    private BigDecimal transactionAmount;

    @Column(name = "transaction_fee")
    private BigDecimal transactionFee;

    @Column(name = "result_code")
    private String resultCode;

    @Column(name = "from_account_number")
    private String fromAccountNumber;

    @Column(name = "to_account_number")
    private String toAccountNumber;

    @Column(name = "to_bank_code")
    private String toBankCode;

    @Column(name = "transaction_exchange_rate")
    private BigDecimal transactionExchangeRate;

    @Column(name = "transaction_state")
    @Enumerated(EnumType.ORDINAL)
    private TransactionState transactionState;

    private String fromAccountOwnerName;

    private String toAccountOwnerName;

    private String toBankName;

//    @Column(name = "COMMISSION_AMOUNT", columnDefinition="NUMBER(19,2) default '0'")
//    private BigDecimal commissionAmount;
}
