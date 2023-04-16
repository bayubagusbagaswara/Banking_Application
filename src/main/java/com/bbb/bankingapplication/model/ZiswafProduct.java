package com.bbb.bankingapplication.model;

import com.bbb.bankingapplication.model.base.UserAudit;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "ziswaf_product")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ZiswafProduct extends UserAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private  Long id;


    @Column(name = "PAYEE_CODE", length = 255, unique = true)
    private String payeeCode;

    @Column(name = "ADDITIONAL_DATA", length = 255)
    private String additionalData;

    @Column(name = "ZISWAF_CATEGORY")
    private Long ziswafCategory;

    @Column(name = "ZISWAF_NAME", length = 255)
    private String ziswafName;

    @Column(name = "ZISWAF_LABEL", length = 255)
    private String ziswafLabel;

    @Column(name = "ZISWAF_PROCESSOR", length = 255)
    private String ziswafProcessor;

    @Column(name = "CREDIT_CARD_ALLOWED")
    private boolean creditCardAllowed;

    @Column(name = "CURRENT_ALLOWED")
    private boolean currentAllowed;

    @Column(name = "SAVING_ALLOWED")
    private boolean savingAllowed;

    @Column(name = "PROVIDER_ID", length = 255)
    private Long providerId;

    @Column(name = "ZISWAF_ACCOUNT", length = 255)
    private String ziswafAccount;

    @Column(name = "IS_DENOM")
    private boolean isDenom;

    @Column(name = "ZISWAF_IMAGE", length = 1000)
    private String ziswafImage;

    @Column(name = "PAYMENT_HANDLER")
    private Integer paymentHandler;

    @Column(name = "TRANSACTION_CATEGORY", length = 255)
    private String transactionCategory;

    @Column(name = "TRANSACTION_CODE", length = 255)
    private String transactionCode;

    @Column(name = "TRANSACTION_GROUP")
    private Integer transactionGroup;

    @Column(name = "PRODUCT_NAME_ID", length = 255)
    private String productNameId;

    @Column(name = "PRODUCT_NAME_EN", length = 255)
    private String productNameEn;

    @Column(name = "PRODUCT_IMAGE", length = 255)
    private String productImage;

    @Column(name = "PRODUCT_CONTENT", columnDefinition="TEXT")
    private String productContent;

    @Column(name = "PRODUCT_SHARE_LINK", length = 255)
    private String shareLink;

    @Column(name = "IS_DELETED")
    private Boolean isDeleted;

    @Column(name = "STATUS")
    private Boolean status;

    @Column(name = "CREATED_BY", length = 255)
    private String createdBy;

    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @Column(name = "MODIFIED_BY", length = 255)
    private String modifiedBy;

    @Column(name = "MODIFIED_DATE")
    private Date modifiedDate;

    @Column(name = "SHARE_LINK", length = 255)
    private String shareLink2;

    @Column(name = "ID_AMIL")
    private Long idAmil;


    @Transient
    private ZiswafCategory ziswafCategoryData;

    @Transient
    private List<ZiswafContentParameter> ziswafContentList;

    @Transient
    private ZiswafAmil ziswafAmil;

}
