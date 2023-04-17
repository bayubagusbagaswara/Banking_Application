package com.bbb.bankingapplication.dto.ziswaf;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ZiswafProductDTO {

    private Long category;
    private String createdBy;
    private String modifiedBy;
    private String transactionCategory;
    private Integer transactionGroup;
    private Date modifiedDate;
    private Date createdDate;
    private Integer paymentHandler;
    private Boolean creditCardAllowed;
    private Boolean savingAllowed;
    private Boolean currentAllowed;
    private Boolean isDeleted;
    private Boolean isDenom;
    private String name;
    private String payeeCode;
    private Boolean status;
    private String ziswafAccount;
    private String productNameId;
    private String productNameEn;
    private String ziswafImage;
    private String productImage;
    private String productContent;
    private String shareLink;
    private Long ziswafCategory;
    private String ziswafName;
    private String ziswafLabel;
    private String additionalData;
    private Integer ordering;
    private ZiswafCategoryDTO ziswafCategoryData;
    private List<ZiswafContentParameterDTO> ziswafContentList;
}
