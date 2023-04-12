package com.bbb.bankingapplication.dto.deposit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModuleNisbahResponse {

    private String moduleNameNisbahBank;
    private String moduleNameNisbahNasabah;
    private String nisbahBank;
    private String nisbahNasabah;

}
