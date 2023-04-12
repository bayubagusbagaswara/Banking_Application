package com.bbb.bankingapplication.repository;

import com.bbb.bankingapplication.model.user.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

    @Query(value = "select account_number as accountNumber, user_profile_id as userProfileId  from user_management_service.user_account where account_number= ?1   and is_deleted=false",
            nativeQuery = true)
    Map<String, Object> getDataByAccountNumber(String accountNumber);

    Optional<UserAccount> findByAccountNumberAndIsDeleted(String accountNumber, boolean isDelete);

    Optional<UserAccount> findByUserProfileId(Long userProfileId);

}
