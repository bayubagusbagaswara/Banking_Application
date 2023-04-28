package com.bbb.bankingapplication.dto.ziswaf.category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateZiswafCategoryRequest {

    private String code;
    private String label;
    private String description;
}
