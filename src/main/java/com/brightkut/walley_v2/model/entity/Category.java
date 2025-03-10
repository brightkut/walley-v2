package com.brightkut.walley_v2.model.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
    @GeneratedValue(strategy = GenerationType.UUID)
    private String categoryId;

    @Column
    private String categoryName;

    @ManyToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;

    @OneToMany(mappedBy = "category")
    private List<Transaction> transactions;
}
