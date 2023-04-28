package com.bbb.bankingapplication.repository;

import com.bbb.bankingapplication.model.ziswaf.ZiswafProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZiswafProductRepository extends JpaRepository<ZiswafProduct, Long> {
}
