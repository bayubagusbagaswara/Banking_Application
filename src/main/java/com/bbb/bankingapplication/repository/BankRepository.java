package com.bbb.bankingapplication.repository;

import com.bbb.bankingapplication.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {

    @Query(value = "SELECT * FROM Bank b WHERE b.bankCode = :bankCode", nativeQuery = true)
    Optional<Bank> findByBankCode(String bankCode);

    @Query(value = "SELECT * FROM Bank b WHERE b.bankName = :bankName", nativeQuery = true)
    Optional<Bank> findByBankName(String bankName);

    @Query(value = "SELECT * FROM Bank b WHERE b.bankShortName = :bankShortName", nativeQuery = true)
    Optional<Bank> findByBankShortName(String bankShortName);

    @Query(value = "SELECT * FROM Bank b WHERE b.swiftCode = :swiftCode", nativeQuery = true)
    Optional<Bank> findBySwiftCode(String swiftCode);

}
