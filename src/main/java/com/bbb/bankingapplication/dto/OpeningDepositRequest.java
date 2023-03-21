package com.bbb.bankingapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OpeningDepositRequest implements Serializable {

    private static final long serialVersionUID = -3014706647039717878L;

    @NotBlank(message = "M PIN must not be blank")
    private String mPin;

    @NotBlank(message = "Product Code must not be blank")
    private String productCode;

    private String systemDeposit;


}
