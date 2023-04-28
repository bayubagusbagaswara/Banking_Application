package com.bbb.bankingapplication.service.impl;

import com.bbb.bankingapplication.dto.ziswaf.amil.AmilDTO;
import com.bbb.bankingapplication.dto.ziswaf.amil.CreateAmilRequest;
import com.bbb.bankingapplication.service.AmilService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AmilServiceImplTest {

    private final static Logger log = LoggerFactory.getLogger(AmilServiceImplTest.class);

    @Autowired
    AmilService amilService;

    @Test
    void createAmil() {
        CreateAmilRequest amilRequest = CreateAmilRequest.builder()
                .amilCode("AMIL001")
                .amilName("BSI Maslahat")
                .amilInitial("BM")
                .address("Jl. Pengadegan Utara IV No 1A Pancoran Jakarta Selatan")
                .image("https://bsi-maslahat.png")
                .build();

        AmilDTO amil = amilService.createAmil(amilRequest);

        assertNotNull(amil.getId());
        assertNotNull(amil.getCreatedAt());
    }

    @Test
    void getAmil() {
        String amilCode = "AMIL001";

        AmilDTO amil = amilService.getAmilByAmilCode(amilCode);
        log.info("Amil : {}", amil.toString());
    }
}