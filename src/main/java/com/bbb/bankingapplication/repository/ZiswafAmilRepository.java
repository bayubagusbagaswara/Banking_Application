package com.bbb.bankingapplication.repository;

import com.bbb.bankingapplication.model.ZiswafAmil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZiswafAmilRepository extends JpaRepository<ZiswafAmil, Long> {
}
