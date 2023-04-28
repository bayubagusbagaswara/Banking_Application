package com.bbb.bankingapplication.dto.ziswaf.category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ZiswafCategoryDTO {

    private String id;
    private String code;
    private String label;
    private String description;

//    List<ZiswafCategoryChildDTO> ziswafCategoryChild;

    private String createdBy;
    private Instant createdAt;
    private String updatedBy;
    private Instant updatedAt;
}
