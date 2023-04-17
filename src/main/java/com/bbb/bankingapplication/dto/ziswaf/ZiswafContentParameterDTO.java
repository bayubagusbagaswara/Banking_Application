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
public class ZiswafContentParameterDTO {
    private Long id;
    private String category;
    private String coderef;
    private Integer ordering;
    private String nameEn;
    private String nameId;
    private String value;
    private String additionalData;
    private String image;
}
