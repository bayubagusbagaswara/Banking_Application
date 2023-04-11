package com.bbb.bankingapplication.dto.deposit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HitungNisbahResponse {

    private BigDecimal depositAmount; // nilai deposit
    private String timePeriod; // jangka waktu
    private String nisbahBagiHasilNasabah; // bagi hasil untuk nasabah (persen)
    private String nisbahBagiHasilBank; // bagi hasil untuk bank (persen)
    private BigDecimal result; // total bagi hasil yang didapat
}
