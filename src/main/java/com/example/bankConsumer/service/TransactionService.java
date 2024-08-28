package com.example.bankConsumer.service;

import com.example.bankConsumer.model.Transaction;
import com.example.bankConsumer.model.TransactionModel;
import com.example.bankConsumer.repository.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class TransactionService {

    @Autowired
    TransactionRepo repo;

    public TransactionModel saveTransaction(Transaction transaction) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss[.SSS][.SS][.S]");
        TransactionModel toSave = new TransactionModel();
        toSave.setId(transaction.getId());
        toSave.setAccount(transaction.getAccount());
        toSave.setType(transaction.getType());
        toSave.setAmount(transaction.getAmount());
        toSave.setDate(LocalDateTime.parse(transaction.getDate(), formatter));
        return repo.save(toSave);
    }
}
