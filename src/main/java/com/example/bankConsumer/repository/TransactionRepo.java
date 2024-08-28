package com.example.bankConsumer.repository;

import com.example.bankConsumer.model.TransactionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepo extends JpaRepository<TransactionModel, Long> {
}
