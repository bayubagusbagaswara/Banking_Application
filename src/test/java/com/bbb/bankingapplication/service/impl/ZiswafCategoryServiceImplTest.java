package com.bbb.bankingapplication.service.impl;

import com.bbb.bankingapplication.dto.ziswaf.category.CreateZiswafCategoryRequest;
import com.bbb.bankingapplication.dto.ziswaf.category.ZiswafCategoryDTO;
import com.bbb.bankingapplication.service.ZiswafCategoryService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ZiswafCategoryServiceImplTest {

    private final static Logger log = LoggerFactory.getLogger(ZiswafCategoryServiceImpl.class);

    @Autowired
    ZiswafCategoryService ziswafCategoryService;

    @Test
    void createZiswafCategory() {
//        "code": "ZISWAF_ZAKAT",
//                "label": "Zakat",
//                "description": "Ziswaf Zakat"
        CreateZiswafCategoryRequest request = CreateZiswafCategoryRequest.builder()
                .code("ZISWAF_ZAKAT")
                .label("Zakat")
                .description("Ziswaf Zakat")
                .build();

        ZiswafCategoryDTO ziswafCategory = ziswafCategoryService.createZiswafCategory(request);
        log.info("Category : {}", ziswafCategory.toString());
    }
}