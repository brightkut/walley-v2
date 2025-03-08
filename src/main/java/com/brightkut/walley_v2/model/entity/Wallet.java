package com.brightkut.walley_v2.model.entity;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name =  "wallet")
@Entity
public class Wallet {
    @Id
    private String walletId; // It is a userId from LINE

    @Column(name = "total_money")
    private BigDecimal totalMoney;

    @OneToMany(mappedBy = "wallet")
    private List<Transaction> transactions;

    @OneToMany(mappedBy = "wallet")
    private List<Category> categories;
}