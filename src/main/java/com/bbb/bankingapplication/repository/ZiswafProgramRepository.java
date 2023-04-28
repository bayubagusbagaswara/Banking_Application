package com.bbb.bankingapplication.repository;

import com.bbb.bankingapplication.model.ziswaf.ZiswafProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZiswafProgramRepository extends JpaRepository<ZiswafProgram, Long> {
}
