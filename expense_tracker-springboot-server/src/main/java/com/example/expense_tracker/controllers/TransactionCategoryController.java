package com.example.expense_tracker.controllers;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.expense_tracker.entities.TransactionCategory;
import com.example.expense_tracker.services.TransactionCategoryService;

@RestController
@RequestMapping("/api/v1/transaction-categories")
public class TransactionCategoryController {
    private static final Logger logger = Logger.getLogger(TransactionCategoryController.class.getName());

    @Autowired
    private TransactionCategoryService transactionCategoryService;

    // get
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TransactionCategory>> getAllTransactionCategoriesByUserId(@PathVariable int userId){
        logger.log(Level.INFO, "Getting all transaction categories from user: {0}", userId);
        List<TransactionCategory> transactionCategories = transactionCategoryService.getAllTransactionCategoriesByUserId(userId);
        return ResponseEntity.status(HttpStatus.OK).body(transactionCategories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionCategory> getTransactionCategoryById(@PathVariable int id){
        logger.log(Level.INFO, "Getting Transaction Category with id: {0}", id);

        Optional<TransactionCategory> transactionCategoryOptional = transactionCategoryService.getTransactionCategoryById(id);
        if(transactionCategoryOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(transactionCategoryOptional.get());
    }

    // post
    @PostMapping
    public ResponseEntity<TransactionCategory> createTransactionCategory(@RequestBody TransactionCategory transactionCategory){
        logger.log(Level.INFO, "Create Transaction Category for: {0}", transactionCategory.getCategoryName());
        transactionCategoryService.createTransactionCategory(
                transactionCategory.getUser().getId(),
                transactionCategory.getCategoryName(),
                transactionCategory.getCategoryColor()
        );

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // update
    @PutMapping("/{id}")
    public ResponseEntity<TransactionCategory> updateTransactionCategoryById(@PathVariable int id,
             @RequestParam String newCategoryName, @RequestParam String newCategoryColor){
        logger.log(Level.INFO, "Updating transaction category with id: {0}", id);

        TransactionCategory updatedTransactionCategory = transactionCategoryService.updateTransactionCategoryById(id,
                newCategoryName, newCategoryColor);
        if(updatedTransactionCategory == null){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(updatedTransactionCategory);
    }

    // delete
    @DeleteMapping("/{id}")
    public ResponseEntity<TransactionCategory> deleteTransactionCategoryById(@PathVariable int id){
        logger.log(Level.INFO, "Deleting transaction category with id: {0}", id);

        if(!transactionCategoryService.deleteTransactionCategoryById(id)){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}











