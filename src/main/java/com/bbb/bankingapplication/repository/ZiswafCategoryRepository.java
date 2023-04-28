package com.bbb.bankingapplication.repository;

import com.bbb.bankingapplication.model.ziswaf.ZiswafCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZiswafCategoryRepository extends JpaRepository<ZiswafCategory, Long> {
}
