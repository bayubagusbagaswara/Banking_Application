package com.bbb.bankingapplication.repository;

import com.bbb.bankingapplication.model.ziswaf.Amil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AmilRepository extends JpaRepository<Amil, Long> {

    Optional<Amil> findByAmilCode(String amilCode);

    Optional<Amil> findByAmilName(String amilName);

    Optional<Amil> findByAmilInitial(String amilInitial);
}
