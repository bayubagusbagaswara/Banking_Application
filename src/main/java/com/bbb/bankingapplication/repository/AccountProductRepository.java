package com.bbb.bankingapplication.repository;

import com.bbb.bankingapplication.model.product.AccountProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountProductRepository extends JpaRepository<AccountProduct, Long> {

//    @Query(value = "SELECT * FROM AccountProduct ap WHERE ap.productCodeName = :codeName", nativeQuery = true)
    Optional<AccountProduct> findAccountProductByProductCodeName(String codeName);

//    @Query(value = "SELECT * FROM AccountProduct ap WHERE ap.productCodeNumber = :codeNumber", nativeQuery = true)
    Optional<AccountProduct> findAccountProductByProductCodeNumber(String codeNumber);
}
