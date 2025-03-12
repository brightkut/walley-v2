package com.brightkut.walley_v2.command.transaction;

import com.brightkut.walley_v2.command.BaseCommand;
import com.brightkut.walley_v2.command.category.ManageCategoryCommand;
import com.brightkut.walley_v2.constant.CommonConstant;
import com.brightkut.walley_v2.model.entity.Transaction;
import com.brightkut.walley_v2.repository.CategoryRepository;
import com.brightkut.walley_v2.repository.TransactionRepository;
import com.brightkut.walley_v2.repository.WalletRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static com.brightkut.walley_v2.constant.CommonConstant.ADD_TRANSACTION;
import static com.brightkut.walley_v2.constant.CommonConstant.ADD_TRANSACTION_RES;
import static com.brightkut.walley_v2.constant.CommonConstant.INCOME;
import static com.brightkut.walley_v2.constant.CommonConstant.INCOME_COMMAND;
import static com.brightkut.walley_v2.constant.CommonConstant.OUTCOME;

@Component
public class AddTransactionCommand implements BaseCommand {
    private static final Logger log = LoggerFactory.getLogger(AddTransactionCommand.class);

    private final WalletRepository walletRepository;
    private final CategoryRepository categoryRepository;
    private final TransactionRepository transactionRepository;

    public AddTransactionCommand(WalletRepository walletRepository, TransactionRepository transactionRepository, CategoryRepository categoryRepository) {
        this.walletRepository = walletRepository;
        this.categoryRepository = categoryRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public String command(String msg, String userId) {
        String[] command = msg.split(" ");

        var wallet = walletRepository.findById(userId);

        if(wallet.isEmpty()){
            log.error("Error occur when wallet does not found");
            return CommonConstant.WALLET_NOT_FOUND_RES;
        }

        var txnType = INCOME_COMMAND.equals(command[1]) ? INCOME : OUTCOME;
        var txnName = command[2];
        var txnTotalMoney = BigDecimal.valueOf(Double.parseDouble(command[3]));
        var categoryName = command[4];
        var txnDate = command[5]; // dd-mm-yyyy

        var category = categoryRepository.findByCategoryName(categoryName, userId);

        if(category.isEmpty()){
            log.error("Error occur when category name = {} not found", categoryName);
            return CommonConstant.CATEGORY_NOT_FOUND_RES;
        }

        var formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        var date = LocalDate.parse(txnDate, formatter);

        var txn = new Transaction()
                .setType(txnType)
                .setName(txnName)
                .setAmount(txnTotalMoney)
                .setDate(date)
                .setCategory(category.get())
                .setWallet(wallet.get());

        category.get().getTransactions().add(txn);
        wallet.get().getTransactions().add(txn);

        transactionRepository.save(txn);

        return String.format(ADD_TRANSACTION_RES, txnType, txnName);
    }

    @Override
    public String getName() {
        return ADD_TRANSACTION;
    }
}
