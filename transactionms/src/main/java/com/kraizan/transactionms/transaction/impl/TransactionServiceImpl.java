package com.kraizan.transactionms.transaction.impl;

import com.kraizan.transactionms.transaction.Transaction;
import com.kraizan.transactionms.transaction.TransactionRepository;
import com.kraizan.transactionms.transaction.TransactionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public List<Transaction> getAllTransactionsForSeller(Long sellerId) {
        return transactionRepository.findBySellerId(sellerId);
    }

    @Override
    public List<Transaction> getAllTransactionsForBuyer(Long buyerId) {
        return transactionRepository.findByBuyerId(buyerId);
    }


    @Override
    public boolean addTransaction(Transaction transaction) {
        if(transaction != null){
            transactionRepository.save(transaction);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Transaction getTransactionById(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    @Override
    public Transaction getTransactionByProductId(Long productId) {
        return transactionRepository.findByProductId(productId);
    }

    @Override
    public boolean deleteTransaction(Long id) {
        Transaction transaction = transactionRepository.findById(id).orElse(null);
        if(transaction != null) {
            transactionRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }
}
