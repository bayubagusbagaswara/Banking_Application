package com.bbb.bankingapplication.service;

import com.bbb.bankingapplication.dto.ziswaf.category.CreateZiswafCategoryRequest;
import com.bbb.bankingapplication.dto.ziswaf.category.UpdateZiswafCategoryRequest;
import com.bbb.bankingapplication.dto.ziswaf.category.ZiswafCategoryDTO;

public interface ZiswafCategoryService {

    // create ZiswafCategory
    ZiswafCategoryDTO createZiswafCategory(CreateZiswafCategoryRequest request);

    // get ZiswafCategory by code
    ZiswafCategoryDTO getZiswafCategoryByCode(String code);

    // update ZiswafCategory
    ZiswafCategoryDTO updateZiswafCategoryByCode(String code, UpdateZiswafCategoryRequest request);

    // delete category
    void deleteZiswafCategoryByCode(String code);
}
