package com.bbb.bankingapplication.dto.deposit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetSysParamByModuleAndNameResponse {

    private String module;
    private String name;
    private String value;
    private String description;
    private Boolean isEncrypt;

}
