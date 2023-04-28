package com.bbb.bankingapplication.service;

import com.bbb.bankingapplication.dto.ziswaf.amil.AmilDTO;
import com.bbb.bankingapplication.dto.ziswaf.amil.CreateAmilRequest;

public interface AmilService {

    // create amil
    AmilDTO createAmil(CreateAmilRequest createAmilRequest);

    // get amil
    AmilDTO getAmilByAmilCode(String amilCode);

    // get amil list

    // update amil

    // delete amil
}
