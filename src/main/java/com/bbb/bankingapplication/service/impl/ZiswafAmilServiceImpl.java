package com.bbb.bankingapplication.service.impl;

import com.bbb.bankingapplication.model.ziswaf.Amil;
import com.bbb.bankingapplication.model.ziswaf.ZiswafAmil;
import com.bbb.bankingapplication.model.ziswaf.ZiswafCategory;
import com.bbb.bankingapplication.repository.AmilRepository;
import com.bbb.bankingapplication.repository.ZiswafAmilRepository;
import com.bbb.bankingapplication.repository.ZiswafCategoryRepository;
import com.bbb.bankingapplication.service.ZiswafAmilService;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class ZiswafAmilServiceImpl implements ZiswafAmilService {

    private final ZiswafCategoryRepository ziswafCategoryRepository;
    private final ZiswafAmilRepository ziswafAmilRepository;
    private final AmilRepository amilRepository;

    public ZiswafAmilServiceImpl(ZiswafCategoryRepository ziswafCategoryRepository, ZiswafAmilRepository ziswafAmilRepository, AmilRepository amilRepository) {
        this.ziswafCategoryRepository = ziswafCategoryRepository;
        this.ziswafAmilRepository = ziswafAmilRepository;
        this.amilRepository = amilRepository;
    }

    @Override
    public void createZiswafAmil(String amilCode, String ziswafCategoryCode) {
        // find Amil by amilCode
        Amil amil = amilRepository.findByAmilCode(amilCode)
                .orElseThrow(() -> new RuntimeException("Amil not found with code: [" + amilCode + "]"));

        // find ZiswafCategory by code
        ZiswafCategory ziswafCategory = ziswafCategoryRepository.findByCode(ziswafCategoryCode)
                .orElseThrow(() -> new RuntimeException("Ziswaf Category not found with code : [" + ziswafCategoryCode + "]"));

        // create ZiswafAmil
        ZiswafAmil ziswafAmil = ZiswafAmil.builder().build();

        ziswafAmil.setCreatedBy("SYSTEM");
        ziswafAmil.setCreatedAt(Instant.now());

        // save ZiswafAmil
        ziswafAmilRepository.save(ziswafAmil);
    }
}
