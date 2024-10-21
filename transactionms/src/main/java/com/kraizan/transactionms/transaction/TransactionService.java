package com.kraizan.transactionms.transaction;

import java.util.List;

public interface TransactionService {
    List<Transaction> getAllTransactions();
    List<Transaction> getAllTransactionsForBuyer(Long buyerId);
    List<Transaction> getAllTransactionsForSeller(Long sellerId);
    boolean addTransaction(Transaction transaction);
    Transaction getTransactionById(Long id);
    Transaction getTransactionByProductId(Long productId);
    boolean deleteTransaction(Long id);
}
