package com.example.bankConsumer.listeners;

import com.example.bankConsumer.model.Transaction;
import com.example.bankConsumer.model.TransactionModel;
import com.example.bankConsumer.repository.TransactionRepo;
import com.example.bankConsumer.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.KafkaException;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.Optional;

@Configuration
public class ConsumerListener {
    private Logger LOGGER = LoggerFactory.getLogger(ConsumerListener.class);

    @Autowired
    TransactionService service;

    @KafkaListener(topics = {"EVT_BANK_ACCOUNT_TRANSACTION"}, groupId = "id", containerFactory = "consumer")
    public void listener(Transaction transaction){
        LOGGER.info("Received transaction: " + transaction.toString());
        TransactionModel saved = service.saveTransaction(transaction);
        if(saved.getId() != null){
            LOGGER.info("Saved transaction: " + saved);
        } else {
            LOGGER.error("Internal error");
        }

    }
}
