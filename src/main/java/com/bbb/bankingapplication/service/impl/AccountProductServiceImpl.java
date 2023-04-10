package com.bbb.bankingapplication.service.impl;

import com.bbb.bankingapplication.dto.AccountProductDTO;
import com.bbb.bankingapplication.dto.CreateAccountProductRequest;
import com.bbb.bankingapplication.model.product.AccountProduct;
import com.bbb.bankingapplication.repository.AccountProductRepository;
import com.bbb.bankingapplication.service.AccountProductService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountProductServiceImpl implements AccountProductService {

    private final AccountProductRepository accountProductRepository;

    public AccountProductServiceImpl(AccountProductRepository accountProductRepository) {
        this.accountProductRepository = accountProductRepository;
    }

    @Override
    public AccountProductDTO saveAccountProduct(CreateAccountProductRequest request) {
        AccountProduct accountProduct = AccountProduct.builder()
                .productCode(request.getProductCode())
                .productName(request.getProductName())
                .productInfo(request.getProductInfo())
                .productDescription(request.getProductDescription())
                .productShortDescription(request.getProductShortDescription())
                .minimumBalance(request.getMinimumBalance())
                .minimumInitialDeposit(request.getMinimumInitialDeposit())
                .productFeature(request.getProductFeature())
                .build();

        LocalDateTime now = LocalDateTime.now();
        accountProduct.setCreatedAt(now);
        accountProduct.setUpdatedAt(now);

        accountProductRepository.save(accountProduct);

        return mapToAccountProductDTO(accountProduct);
    }

    @Override
    public AccountProductDTO getAccountProductByName(String productName) {
        AccountProduct accountProduct = accountProductRepository.findAccountProductByName(productName)
                .orElseThrow(() -> new RuntimeException("Account Product not found with name : [" + productName + "]"));
        return mapToAccountProductDTO(accountProduct);
    }

    @Override
    public AccountProductDTO getAccountProductByCode(String productCode) {
        AccountProduct accountProduct = accountProductRepository.findAccountProductByCode(productCode)
                .orElseThrow(() -> new RuntimeException("Account Product not found with code : [" + productCode + "]"));
        return mapToAccountProductDTO(accountProduct);
    }

    private static AccountProductDTO mapToAccountProductDTO(AccountProduct accountProduct) {
        return AccountProductDTO.builder()
                .id(String.valueOf(accountProduct.getId()))
                .productCode(accountProduct.getProductCode())
                .productName(accountProduct.getProductName())
                .productInfo(accountProduct.getProductInfo())
                .productDescription(accountProduct.getProductDescription())
                .productShortDescription(accountProduct.getProductShortDescription())
                .minimumBalance(accountProduct.getMinimumBalance())
                .minimumInitialDeposit(accountProduct.getMinimumInitialDeposit())
                .productFeature(accountProduct.getProductFeature())
                .createdAt(accountProduct.getCreatedAt())
                .createdBy(accountProduct.getCreatedBy())
                .updatedAt(accountProduct.getUpdatedAt())
                .updatedBy(accountProduct.getUpdatedBy())
                .build();
    }

    private static List<AccountProductDTO> mapToAccountProductDTOList(List<AccountProduct> accountProductList) {
        return accountProductList
                .stream()
                .map(AccountProductServiceImpl::mapToAccountProductDTO)
                .collect(Collectors.toList());
    }

}
