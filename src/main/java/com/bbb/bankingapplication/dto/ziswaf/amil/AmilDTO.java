package com.bbb.bankingapplication.dto.ziswaf.amil;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AmilDTO {

    private String id;

    private String amilCode;

    private String amilName;

    private String amilInitial;

    private String address;

    private String image;

    private String createdBy;
    private Instant createdAt;
    private String updatedBy;
    private Instant updatedAt;

}
