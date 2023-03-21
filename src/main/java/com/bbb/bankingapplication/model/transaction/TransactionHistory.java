package com.bbb.bankingapplication.model.transaction;

import com.bbb.bankingapplication.model.base.UserAudit;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

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

    private BigDecimal amount;
}
