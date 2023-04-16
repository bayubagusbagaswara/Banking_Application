package com.bbb.bankingapplication.model;

import com.bbb.bankingapplication.model.base.UserAudit;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "ziswaf_category")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ZiswafCategory extends UserAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "code", length = 255)
    private String code;

    @Column(name = "created_by", length = 255)
    private String createdBy;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "DESCRIPTION", length = 255)
    private String description;

    @Column(name = "image", length = 255)
    private String image;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @Column(name = "modified_date")
    private Date modifiedDate;

    @Column(name = "modified_by", length = 255)
    private String modifiedBy;

    @Column(name = "label_en", length = 255)
    private String nameEn;

    @Column(name = "label_id", length = 255)
    private String nameId;

    @Column(name = "no_order")
    private Integer noOrder;

    @Column(name = "parent_category_id")
    private Long parentCategoryId;

    @Column(name = "service_category", length = 255)
    private String serviceCategory;

    @Column(name = "tran_code", length = 255)
    private String tranCode;

    @Column(name = "use_prefix")
    private Boolean usePrefix;


    @Column(name = "status")
    private Boolean status;

}
