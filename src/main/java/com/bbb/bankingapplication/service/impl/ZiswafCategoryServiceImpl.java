package com.bbb.bankingapplication.service.impl;

import com.bbb.bankingapplication.dto.ziswaf.category.CreateZiswafCategoryRequest;
import com.bbb.bankingapplication.dto.ziswaf.category.UpdateZiswafCategoryRequest;
import com.bbb.bankingapplication.dto.ziswaf.category.ZiswafCategoryDTO;
import com.bbb.bankingapplication.model.ziswaf.ZiswafCategory;
import com.bbb.bankingapplication.repository.ZiswafCategoryRepository;
import com.bbb.bankingapplication.service.ZiswafCategoryService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ZiswafCategoryServiceImpl implements ZiswafCategoryService {

    private final ZiswafCategoryRepository ziswafCategoryRepository;

    public ZiswafCategoryServiceImpl(ZiswafCategoryRepository ziswafCategoryRepository) {
        this.ziswafCategoryRepository = ziswafCategoryRepository;
    }

    @Override
    public ZiswafCategoryDTO createZiswafCategory(CreateZiswafCategoryRequest request) {
        // check apakah code sudah ada di database
        ZiswafCategory ziswafCategory = ZiswafCategory.builder()
                .code(request.getCode())
                .label(request.getLabel())
                .description(request.getDescription())
                .build();

        ziswafCategory.setCreatedBy("SYSTEM");
        ziswafCategory.setCreatedAt(Instant.now());

        ziswafCategoryRepository.save(ziswafCategory);

        return mapToZiswafCategoryDTO(ziswafCategory);
    }

    @Override
    public ZiswafCategoryDTO getZiswafCategoryByCode(String code) {
        ZiswafCategory ziswafCategory = ziswafCategoryRepository.findByCode(code)
                .orElseThrow(() -> new RuntimeException("Ziswaf Category not found with code : [" + code + "]"));
        return mapToZiswafCategoryDTO(ziswafCategory);
    }

    @Override
    public ZiswafCategoryDTO updateZiswafCategoryByCode(String code, UpdateZiswafCategoryRequest request) {
        ZiswafCategory ziswafCategory = ziswafCategoryRepository.findByCode(code)
                .orElseThrow(() -> new RuntimeException("Ziswaf Category not found with code : [" + code + "]"));
        ziswafCategory.setCode(request.getCode());
        ziswafCategory.setLabel(request.getLabel());
        ziswafCategory.setDescription(request.getDescription());
        ziswafCategory.setUpdatedAt(Instant.now());

        ziswafCategoryRepository.save(ziswafCategory);

        return mapToZiswafCategoryDTO(ziswafCategory);
    }

    @Override
    public void deleteZiswafCategoryByCode(String code) {
        ZiswafCategory ziswafCategory = ziswafCategoryRepository.findByCode(code)
                .orElseThrow(() -> new RuntimeException("Ziswaf Category not found with code : [" + code + "]"));

        ziswafCategory.setDeleted(true);

        ziswafCategoryRepository.save(ziswafCategory);
    }

    private static ZiswafCategoryDTO mapToZiswafCategoryDTO(ZiswafCategory ziswafCategory) {
        return ZiswafCategoryDTO.builder()
                .id(String.valueOf(ziswafCategory.getId()))
                .code(ziswafCategory.getCode())
                .label(ziswafCategory.getLabel())
                .description(ziswafCategory.getDescription())
                .createdBy(ziswafCategory.getCreatedBy())
                .createdAt(ziswafCategory.getCreatedAt())
                .updatedBy(ziswafCategory.getUpdatedBy())
                .updatedAt(ziswafCategory.getUpdatedAt())
                .build();
    }

    private static List<ZiswafCategoryDTO> mapToZiswafCategoryDTOList(List<ZiswafCategory> ziswafCategoryList) {
        return ziswafCategoryList.stream()
                .map(ZiswafCategoryServiceImpl::mapToZiswafCategoryDTO)
                .collect(Collectors.toList());
    }

}
