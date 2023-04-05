package com.bbb.bankingapplication.repository;

import com.bbb.bankingapplication.model.account.AccountDeposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDepositRepository extends JpaRepository<AccountDeposit, Long> {
}
