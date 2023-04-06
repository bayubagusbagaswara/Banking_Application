package com.bbb.bankingapplication.service.impl;

import com.bbb.bankingapplication.dto.deposit.TransferOnlineRequest;
import com.bbb.bankingapplication.dto.transfer.TransferRequestDTO;
import com.bbb.bankingapplication.dto.transfer.TransferResponseDTO;
import com.bbb.bankingapplication.model.user.UserAccount;
import com.bbb.bankingapplication.repository.TransactionHistoryRepository;
import com.bbb.bankingapplication.repository.UserAccountRepository;
import com.bbb.bankingapplication.repository.UserProfileRepository;
import com.bbb.bankingapplication.service.TransferService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class TransferServiceImpl implements TransferService {

    private final UserProfileRepository userProfileRepository;
    private final UserAccountRepository userAccountRepository;
    private final TransactionHistoryRepository transactionHistoryRepository;

    public TransferServiceImpl(UserProfileRepository userProfileRepository, UserAccountRepository userAccountRepository, TransactionHistoryRepository transactionHistoryRepository) {
        this.userProfileRepository = userProfileRepository;
        this.userAccountRepository = userAccountRepository;
        this.transactionHistoryRepository = transactionHistoryRepository;
    }

    @Override
    public void transfer(Long fromAccountId, Long toAccountId, BigDecimal amount) {

        // ini transfer sederhana

        // cari account formAccount by id
        UserAccount fromAccount = userAccountRepository.findById(fromAccountId)
                .orElseThrow(() -> new RuntimeException("From Account not found with id : [" + fromAccountId + "]"));

        // cari account toAccount by id
        UserAccount toAccount = userAccountRepository.findById(toAccountId)
                .orElseThrow(() -> new RuntimeException("To Account not found with id : [" + toAccountId + "]"));

        // tambahkan saldo toAccount dan kurangi saldo fromAccount

        // simpan transaction di TransactionHistory untuk fromAccount dan toAccount

        // balikannya adalah String
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    }

    @Override
    public TransferResponseDTO transferOnlineInquiry(TransferRequestDTO request) {
        return null;
    }

    @Override
    public TransferResponseDTO transferOnline(TransferRequestDTO request) {

        // transfer dilakukan ke esb service
        // setelah berhasil, maka esb akan memberikan response
        // lalu response itu akan dimapping ke mappingResponse
        // di mapping response kita setting TransactionStatus
        // code balikan ESB adalah 00 dan 02. 00 -> SUCCESS, 02 -> SUSPECT, selain itu maka FAILED

        // kita create object TransferOnlineRequest, lalu passing data dari TransferRequestDTO ke TransferOnlineRequest
        TransferOnlineRequest transferOnlineRequest = mapToTransferOnlineRequest(request);

        // response nya apa jika transferOnlineRequest berhasil
        // disini manual harus menambah dan mengurangi amount masing-masing rekenig
        // berarti di masing-masing rekening ada data amount

        // lalu mapping response menjadi TransferResponseDTO

        return null;
    }

    private static TransferOnlineRequest mapToTransferOnlineRequest(TransferRequestDTO request) {
        return TransferOnlineRequest.builder()
                .amount(request.getTransactionAmount().toString())
                .currency(request.getTransactionCurrency())
                .transactionDate(generateTransactionDate())
                .beneficiaryBankCode(request.getToBankCode())
                .beneficiaryBankName(request.getToBankName())
                .beneficiaryAccountNumber(request.getToAccountNumber())
                .beneficiaryAccountName(request.getToAccountOwnerName())
                .sourceAccountNumber(request.getFromAccountNumber())
                .sourceAccountName(request.getFromAccountOwnerName())
                .build();
    }

    private static String generateTransactionDate() {
        return (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX")).format(new Date());
    }

    // map TransactionData to TransactionHistory
}
