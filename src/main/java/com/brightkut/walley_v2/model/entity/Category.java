package com.brightkut.walley_v2.model.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "category")
@Entity
public class Category {
    @Id
    private String categoryId;

    @Column(unique = true)
    private String categoryName;

    @ManyToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;
    
    @OneToOne
    @JoinColumn(name = "transaction_id")
    private Transaction transaction;
}
