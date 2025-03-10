package com.brightkut.walley_v2.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.brightkut.walley_v2.model.entity.Category;


public interface CategoryRepository extends JpaRepository<Category, String> {
    @Query("SELECT c FROM Category c WHERE c.categoryName = :categoryName AND c.wallet.walletId = :walletId")
    Optional<Category> findByCategoryName(@Param("categoryName") String categoryName, @Param("walletId") String walletId);

    @Query("SELECT c FROM Category c WHERE c.wallet.walletId = :walletId")
    List<Category> findAllByWalletId(String walletId);
}
