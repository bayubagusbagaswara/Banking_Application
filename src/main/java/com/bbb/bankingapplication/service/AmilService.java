package com.bbb.bankingapplication.service;

import com.bbb.bankingapplication.dto.ziswaf.amil.AmilDTO;
import com.bbb.bankingapplication.dto.ziswaf.amil.CreateAmilRequest;

import java.util.List;

public interface AmilService {

    // create amil
    AmilDTO createAmil(CreateAmilRequest createAmilRequest);

    // get amil
    AmilDTO getAmilByAmilCode(String amilCode);

    // get amil list
    List<AmilDTO> getAmilList();

    // update amil

    // delete amil
}
