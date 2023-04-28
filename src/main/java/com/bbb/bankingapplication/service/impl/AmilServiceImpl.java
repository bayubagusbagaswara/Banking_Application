package com.bbb.bankingapplication.service.impl;

import com.bbb.bankingapplication.dto.ziswaf.amil.AmilDTO;
import com.bbb.bankingapplication.dto.ziswaf.amil.CreateAmilRequest;
import com.bbb.bankingapplication.model.ziswaf.Amil;
import com.bbb.bankingapplication.repository.AmilRepository;
import com.bbb.bankingapplication.service.AmilService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AmilServiceImpl implements AmilService {

    private final AmilRepository amilRepository;

    public AmilServiceImpl(AmilRepository amilRepository) {
        this.amilRepository = amilRepository;
    }

    @Override
    public AmilDTO createAmil(CreateAmilRequest createAmilRequest) {

        // cek amilCode apakah sudah ada di database
        // cek amil initial apakah sudah ada di database

        Amil amil = Amil.builder()
                .amilCode(createAmilRequest.getAmilCode())
                .amilName(createAmilRequest.getAmilName())
                .amilInitial(createAmilRequest.getAmilInitial())
                .address(createAmilRequest.getAddress())
                .image(createAmilRequest.getImage())
                .build();

        amil.setCreatedBy("SYSTEM");
        amil.setCreatedAt(Instant.now());

        amilRepository.save(amil);

        return mapToAmilDTO(amil);
    }

    @Override
    public AmilDTO getAmilByAmilCode(String amilCode) {
        Amil amil = amilRepository.findByAmilCode(amilCode)
                .orElseThrow(() -> new RuntimeException("Amil not found with code : [" + amilCode + "]"));
        return mapToAmilDTO(amil);
    }

    private static AmilDTO mapToAmilDTO(Amil amil) {
        return AmilDTO.builder()
                .id(String.valueOf(amil.getId()))
                .amilCode(amil.getAmilCode())
                .amilName(amil.getAmilName())
                .amilInitial(amil.getAmilInitial())
                .address(amil.getAddress())
                .image(amil.getImage())
                .createdBy(amil.getCreatedBy())
                .createdAt(amil.getCreatedAt())
                .updatedBy(amil.getUpdatedBy())
                .updatedAt(amil.getUpdatedAt())
                .build();
    }

    private static List<AmilDTO> mapToAmilDTOList(List<Amil> amilList) {
        return amilList.stream()
                .map(AmilServiceImpl::mapToAmilDTO)
                .collect(Collectors.toList());
    }
}
