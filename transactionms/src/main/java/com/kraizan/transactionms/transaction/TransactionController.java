package com.kraizan.transactionms.transaction;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions(@RequestParam(required = false) Long sellerId, @RequestParam(required = false) Long buyerId) {
        List<Transaction> transactions;
        if(sellerId != null){
            transactions = transactionService.getAllTransactionsForSeller(sellerId);
        } else if (buyerId != null) {
            transactions = transactionService.getAllTransactionsForBuyer(buyerId);
        } else {
            transactions = transactionService.getAllTransactions();
        }
        if (transactions.isEmpty()) {
            return new ResponseEntity<>(transactions, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(transactions, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<String> addTransaction(@RequestBody Transaction transaction) {
        boolean isAdded = transactionService.addTransaction(transaction);
        if (isAdded) {
            return new ResponseEntity<>("Transaction added successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to add transaction", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable Long id) {
        Transaction transaction = transactionService.getTransactionById(id);
        if (transaction != null) {
            return new ResponseEntity<>(transaction, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTransaction(@PathVariable Long id) {
        boolean isDeleted = transactionService.deleteTransaction(id);
        if (isDeleted) {
            return new ResponseEntity<>("Transaction deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to delete transaction", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

