package com.bbb.bankingapplication.model;

import com.bbb.bankingapplication.model.base.UserAudit;
import lombok.*;

import javax.persistence.*;

/**
 * Data nasabah untuk pembukaan akun / rekening
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

    @Column(name = "name")
    private String name;
}
