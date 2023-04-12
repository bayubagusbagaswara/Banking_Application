package com.bbb.bankingapplication.service.impl;

import com.bbb.bankingapplication.dto.bank.*;
import com.bbb.bankingapplication.model.Bank;
import com.bbb.bankingapplication.repository.BankRepository;
import com.bbb.bankingapplication.service.BankService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BankServiceImpl implements BankService {

    private final BankRepository bankRepository;

    public BankServiceImpl(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @Override
    public CreateBankResponse saveBank(CreateBankRequest request) {
        Bank bank = Bank.builder()
                .bankCode(request.getBankCode())
                .areaCode(request.getAreaCode())
                .bankName(request.getBankName())
                .bankNetwork(request.getBankNetwork())
                .bankShortName(request.getBankShortName())
                .biFastCode(request.getBiFastCode())
                .ordering(Integer.valueOf(request.getOrdering()))
                .rtgsCode(request.getRtgsCode())
                .sknCode(request.getSknCode())
                .swiftCode(request.getSwiftCode())
                .build();

        Instant now = Instant.now();
        bank.setCreatedAt(now);
        bank.setUpdatedAt(now);

        bankRepository.save(bank);

        // kita coba setelah createBank, maka kita balikan hasil save nya
        // hasil save Bank akan disimpan ke caching
        // lalu kita coba get bank di caching, coba dengan jeda waktu yang berbeda

        return mapToBankResponse(bank);
    }

    @Override
    public BankDTO getBankById(Long id) {
        Bank bank = bankRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bank not found with id : [" + id + "]"));
        return mapToBankDTO(bank);
    }

    @Override
    public BankDTO getBankByCode(String bankCode) {
        Bank bank = bankRepository.findByBankCode(bankCode)
                .orElseThrow(() -> new RuntimeException("Bank not found with code : [" + bankCode + "]"));
        return mapToBankDTO(bank);
    }

    @Override
    public BankDTO getBankBySwiftCode(String swiftCode) {
        Bank bank = bankRepository.findBySwiftCode(swiftCode)
                .orElseThrow(() -> new RuntimeException("Bank not found with swift code : [" + swiftCode + "]"));
        return mapToBankDTO(bank);
    }

    @Override
    public List<BankDTO> getAllBankList() {
        List<Bank> bankList = bankRepository.findAll();
        return mapToBankDTOList(bankList);
    }

    @Override
    public UpdateBankResponse updateBank(Long bankId, UpdateBankRequest request) {
        return null;
    }

    @Override
    public void deleteBank(Long bankId) {
        Bank bank = bankRepository.findById(bankId)
                .orElseThrow(() -> new RuntimeException("Bank not found with id : [" + bankId + "]"));

        // soft delete
        bank.setDeleted(true);
        bank.setDeletedAt(Instant.now());

        bankRepository.save(bank);
    }

    private static CreateBankResponse mapToBankResponse(Bank bank) {
        return CreateBankResponse.builder()
                .id(String.valueOf(bank.getId()))
                .bankCode(bank.getBankCode())
                .areaCode(bank.getAreaCode())
                .bankName(bank.getBankName())
                .bankNetwork(bank.getBankNetwork())
                .bankShortName(bank.getBankShortName())
                .biFastCode(bank.getBiFastCode())
                .ordering(String.valueOf(bank.getOrdering()))
                .rtgsCode(bank.getRtgsCode())
                .sknCode(bank.getSknCode())
                .swiftCode(bank.getSwiftCode())
                .createdAt(bank.getCreatedAt())
                .updatedAt(bank.getUpdatedAt())
                .build();
    }

    private static BankDTO mapToBankDTO(Bank bank) {
        return BankDTO.builder()
                .id(String.valueOf(bank.getId()))
                .bankCode(bank.getBankCode())
                .areaCode(bank.getAreaCode())
                .bankName(bank.getBankName())
                .bankNetwork(bank.getBankNetwork())
                .bankShortName(bank.getBankShortName())
                .biFastCode(bank.getBiFastCode())
                .ordering(String.valueOf(bank.getOrdering()))
                .rtgsCode(bank.getRtgsCode())
                .sknCode(bank.getSknCode())
                .swiftCode(bank.getSwiftCode())
                .createdAt(bank.getCreatedAt())
                .updatedAt(bank.getUpdatedAt())
                .createdBy(bank.getCreatedBy())
                .updatedBy(bank.getUpdatedBy())
                .build();
    }

    private static List<BankDTO> mapToBankDTOList(List<Bank> bankList) {
        return bankList.stream()
                .map(BankServiceImpl::mapToBankDTO)
                .collect(Collectors.toList());
    }

}
