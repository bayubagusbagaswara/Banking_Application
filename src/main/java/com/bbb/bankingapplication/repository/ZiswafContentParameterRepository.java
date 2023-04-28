package com.bbb.bankingapplication.repository;

import com.bbb.bankingapplication.model.ziswaf.ZiswafContentParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZiswafContentParameterRepository extends JpaRepository<ZiswafContentParameter, Long> {
}
