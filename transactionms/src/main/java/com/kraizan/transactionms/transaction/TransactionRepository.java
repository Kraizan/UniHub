package com.kraizan.transactionms.transaction;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findBySellerId(Long sellerId);
    List<Transaction> findByBuyerId(Long buyerId);
    Transaction findByProductId(Long productId);
}
