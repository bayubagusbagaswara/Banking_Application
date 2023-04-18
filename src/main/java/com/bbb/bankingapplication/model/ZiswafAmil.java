package com.bbb.bankingapplication.model;

import com.bbb.bankingapplication.model.base.UserAudit;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "ziswaf_amil")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ZiswafAmil extends UserAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "created_date", nullable = false)
    private Date createdDate;

    @Column(name = "created_by", length = 255, nullable = false)
    private String createdBy;

    @Column(name = "modified_date")
    private Date modifiedDate;

    @Column(name = "modified_by", length = 255)
    private String modifiedBy;

    @Column(name = "CATEGORY", length = 255)
    private String category;

    @Column(name = "ID_CATEGORY", nullable = false)
    private Long idCategory;

    @Column(name = "AMIL_NAME", length = 255)
    private String amilName;

    @Column(name = "DISPLAY_NAME", length = 255)
    private String displayName;

    @Column(name = "ADDRESS", length = 255)
    private String address;

    @Column(name = "ACCOUNT_NUMBER", length = 255)
    private String accountNumber;

    @Column(name = "VA_NUMBER", length = 255)
    private String vaNumber;

//    @Column(name = "isdeleted", nullable = false, columnDefinition = "DEFAULT '0'")
//    private boolean isDeleted;

    @Column(name = "IMAGE", length = 255)
    private String image;

    @Column(name = "AMIL_INIIAL", length = 255)
    private String amilInitial;

//    @Column(name = "STATUS", nullable = false, columnDefinition = "DEFAULT '1'")
//    private Boolean status;

}
