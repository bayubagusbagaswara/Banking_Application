package com.bbb.bankingapplication.repository;

import com.bbb.bankingapplication.model.ziswaf.ZiswafCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ZiswafCategoryRepository extends JpaRepository<ZiswafCategory, Long> {

    Optional<ZiswafCategory> findByCode(String code);
}
