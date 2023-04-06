package com.bbb.bankingapplication.repository;

import com.bbb.bankingapplication.model.product.AccountProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountProductRepository extends JpaRepository<AccountProduct, Long> {
}
