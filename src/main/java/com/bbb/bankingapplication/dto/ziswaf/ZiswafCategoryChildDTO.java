package com.bbb.bankingapplication.dto.ziswaf;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ZiswafCategoryChildDTO {
    private Long id;
    private String code;
    private String nameEd;
    private String nameId;
    private Integer noOrder;
    private Boolean isDeleted;
}
