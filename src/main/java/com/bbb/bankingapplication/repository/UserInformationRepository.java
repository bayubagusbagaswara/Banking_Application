package com.bbb.bankingapplication.repository;

import com.bbb.bankingapplication.model.user.UserInformation;
import com.bbb.bankingapplication.model.user.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserInformationRepository extends JpaRepository<UserInformation, Long> {

    Optional<UserInformation> findByUserProfile(UserProfile userProfile);

    Optional<UserInformation> findByNik(String nik);

    List<UserInformation> findUserByNik(String nik);
}
