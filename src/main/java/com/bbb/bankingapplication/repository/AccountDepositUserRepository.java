package com.bbb.bankingapplication.repository;

import com.bbb.bankingapplication.model.user.AccountDepositUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDepositUserRepository extends JpaRepository<AccountDepositUser, Long> {
}
