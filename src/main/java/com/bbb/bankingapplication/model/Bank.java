package com.bbb.bankingapplication.model;

import com.bbb.bankingapplication.model.base.UserAudit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Information about Bank
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "bank")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Bank extends UserAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @Column(name = "bank_code", nullable = false)
    private String bankCode;

    @Column(name = "area_code")
    private String areaCode;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "bank_network")
    private String bankNetwork;

    @Column(name = "bank_short_name")
    private String bankShortName;

    @Column(name = "bi_fast_code")
    private String biFastCode;

    @Column(name = "ordering")
    private Integer ordering;

    @Column(name = "rtgs_code")
    private String rtgsCode;

    @Column(name = "skn_code")
    private String sknCode;

    @Column(name = "swift_code")
    private String swiftCode;

    @Column(name = "transfer_bi_fast_allowed")
    private Boolean transferBiFastAllowed;

    @Column(name = "transfer_online_allowed")
    private Boolean transferOnlineAllowed;

    @Column(name = "transfer_rtgs_allowed")
    private Boolean transferRtgsAllowed;

    @Column(name = "transfer_skn_allowed")
    private Boolean transferSknAllowed;

    @Column(name = "status")
    private boolean status;

}
