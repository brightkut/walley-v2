package com.brightkut.walley_v2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.brightkut.walley_v2.model.entity.Category;


public interface CategoryRepository extends JpaRepository<Category, String> {
    // @Query("SELECT c FROM Category c INNER JOIN WALLET w ON c.walletId = w.walletId WHERE c.categoryName = :categoryName AND c.walletId = :walletId")
    // Category findByCategoryName(String walletId, String categoryName);
}
