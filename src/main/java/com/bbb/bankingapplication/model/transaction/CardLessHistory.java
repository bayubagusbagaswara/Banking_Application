package com.bbb.bankingapplication.model.transaction;

import com.bbb.bankingapplication.model.base.UserAudit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * semua transaksi tanpa kartu
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "card_less_history")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardLessHistory extends UserAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "card_less_ref_number")
    private String cardLessRefNumber;

    @Column(name = "user_profile_id")
    private Long userProfileId;

    @Column(name = "card_less_token")
    private String cardLessToken;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "card_less_category")
    private String cardLessCategory;

    @Column(name = "card_less_expired_date")
    private Date cardLessExpiredDate;

    @Column(name = "transaction_date")
    private Date transactionDate;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "card_less_status")
    private Integer cardLessStatus;

    @Column(name = "additional_data")
    private String additionalData;

    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "result_code")
    private String resultCode;

    @Column(name = "admin_fee")
    private BigDecimal adminFee;
}
