package com.bbb.bankingapplication.dto.ziswaf;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ZiswafCategoryDTO {

    private Long id;
    private String tranCode;
    private String code;
    private Integer noOrder;
    private String nameEn;
    private String nameId;
    private Boolean status;
    private Boolean isPrefix;
    List<ZiswafCategoryChildDTO> ziswafCategoryChild;
}
