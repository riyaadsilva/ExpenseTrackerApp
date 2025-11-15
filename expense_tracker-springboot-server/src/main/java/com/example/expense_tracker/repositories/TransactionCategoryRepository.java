package com.example.expense_tracker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.expense_tracker.entities.TransactionCategory;

public interface TransactionCategoryRepository extends JpaRepository<TransactionCategory, Integer> {
    List<TransactionCategory> findAllByUserId(int userId);
}