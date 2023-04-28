package com.bbb.bankingapplication.service.impl;

import com.bbb.bankingapplication.repository.ZiswafAmilRepository;
import com.bbb.bankingapplication.service.ZiswafAmilService;
import org.springframework.stereotype.Service;

@Service
public class ZiswafAmilServiceImpl implements ZiswafAmilService {

    private final ZiswafAmilRepository ziswafAmilRepository;

    public ZiswafAmilServiceImpl(ZiswafAmilRepository ziswafAmilRepository) {
        this.ziswafAmilRepository = ziswafAmilRepository;
    }
}
