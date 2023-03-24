package com.bbb.bankingapplication.repository;

import com.bbb.bankingapplication.model.user.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

    Optional<UserProfile> findByCifAndIsDeletedFalse(String cif);

    default Optional<UserProfile> findByCif(String cif) {
        return findByCifAndIsDeletedFalse(cif);
    }

}
