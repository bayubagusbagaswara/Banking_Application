package com.bbb.bankingapplication.dto.ziswaf.amil;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateAmilRequest {

    private String amilCode;

    private String amilName;

    private String amilInitial;

    private String address;

    private String image;
}
