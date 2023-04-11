package com.bbb.bankingapplication.service.impl;

import com.bbb.bankingapplication.dto.AccountProductDTO;
import com.bbb.bankingapplication.dto.CreateAccountProductRequest;
import com.bbb.bankingapplication.dto.UpdateAccountProductRequest;
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
                .productCodeNumber(request.getProductCodeNumber())
                .productCodeName(request.getProductCodeName())
                .productTitle(request.getProductTitle())
                .productDescription(request.getProductDescription())
                .productShortDescription(request.getProductShortDescription())
                .minimumBalance(request.getMinimumBalance())
                .minimumInitialDeposit(request.getMinimumInitialDeposit())
                .build();

        LocalDateTime now = LocalDateTime.now();
        accountProduct.setCreatedAt(now);
        accountProduct.setUpdatedAt(now);

        accountProductRepository.save(accountProduct);

        return mapToAccountProductDTO(accountProduct);
    }

    @Override
    public AccountProductDTO getAccountProductByCodeName(String productCodeName) {
        AccountProduct accountProduct = accountProductRepository.findProductByCodeName(productCodeName)
                .orElseThrow(() -> new RuntimeException("Account Product not found with name : [" + productCodeName + "]"));
        return mapToAccountProductDTO(accountProduct);
    }

    @Override
    public AccountProductDTO getAccountProductByCodeNumber(String productCodeNumber) {
        AccountProduct accountProduct = accountProductRepository.findProductByCodeNumber(productCodeNumber)
                .orElseThrow(() -> new RuntimeException("Account Product not found with code : [" + productCodeNumber + "]"));
        return mapToAccountProductDTO(accountProduct);
    }

    @Override
    public AccountProductDTO updateAccountProduct(String productCodeNumber, UpdateAccountProductRequest request) {
        AccountProduct accountProduct = accountProductRepository.findProductByCodeNumber(productCodeNumber)
                .orElseThrow(() -> new RuntimeException("Account Product not found with code number : [" + productCodeNumber + "]"));

        // update
        accountProduct.setProductCodeNumber(request.getProductCodeNumber());
        accountProduct.setProductCodeName(request.getProductCodeName());
        accountProduct.setProductTitle(request.getProductTitle());
        accountProduct.setProductDescription(request.getProductDescription());
        accountProduct.setProductShortDescription(request.getProductShortDescription());
        accountProduct.setMinimumBalance(request.getMinimumBalance());
        accountProduct.setMinimumInitialDeposit(request.getMinimumInitialDeposit());

        // updated at
        accountProduct.setUpdatedAt(LocalDateTime.now());

        accountProductRepository.save(accountProduct);

        return mapToAccountProductDTO(accountProduct);
    }

    @Override
    public void deleteAccountProduct(String productCodeNumber) {
        // soft delete manual, set deleted to false
        // search product by code number
        AccountProduct accountProduct = accountProductRepository.findProductByCodeNumber(productCodeNumber)
                .orElseThrow(() -> new RuntimeException("Account Product not found with code number : [" + productCodeNumber + "]"));

        accountProduct.setDeleted(true);

        accountProductRepository.save(accountProduct);
    }

    private static AccountProductDTO mapToAccountProductDTO(AccountProduct accountProduct) {
        return AccountProductDTO.builder()
                .id(String.valueOf(accountProduct.getId()))
                .productCodeNumber(accountProduct.getProductCodeNumber())
                .productCodeName(accountProduct.getProductCodeName())
                .productTitle(accountProduct.getProductTitle())
                .productDescription(accountProduct.getProductDescription())
                .productShortDescription(accountProduct.getProductShortDescription())
                .minimumBalance(accountProduct.getMinimumBalance())
                .minimumInitialDeposit(accountProduct.getMinimumInitialDeposit())
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
