package com.example.expense_tracker.services;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.expense_tracker.entities.TransactionCategory;
import com.example.expense_tracker.entities.User;
import com.example.expense_tracker.repositories.TransactionCategoryRepository;
import com.example.expense_tracker.repositories.UserRepository;

@Service
public class TransactionCategoryService {
    private static final Logger logger = Logger.getLogger(TransactionCategoryService.class.getName());

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionCategoryRepository transactionCategoryRepository;

    // get
    public Optional<TransactionCategory> getTransactionCategoryById(int id){
        logger.log(Level.INFO, "Getting transaction category by id: {0}", id);
        return transactionCategoryRepository.findById(id);
    }

    public List<TransactionCategory> getAllTransactionCategoriesByUserId(int userId){
        logger.log(Level.INFO, "Getting all transaction categories from user: {0}", userId);
        return transactionCategoryRepository.findAllByUserId(userId);
    }

    // post
    public TransactionCategory createTransactionCategory(int userId, String categoryName, String categoryColor){
        logger.log(Level.INFO, "Create Transaction Category with user: {0}", userId);

        // find the user with the userId
        Optional<User> user = userRepository.findById(userId);

        if(user.isEmpty()) return null;

        TransactionCategory transactionCategory = new TransactionCategory();
        transactionCategory.setUser(user.get());
        transactionCategory.setCategoryName(categoryName);
        transactionCategory.setCategoryColor(categoryColor);

        return transactionCategoryRepository.save(transactionCategory);
    }

    // update (put)
    public TransactionCategory updateTransactionCategoryById(int transactionCategoryId, String newCategoryName,
                                                             String newCategoryColor){
        logger.log(Level.INFO, "Updating TransactionCategory with Id: {0}", transactionCategoryId);

        Optional<TransactionCategory> transactionCategoryOptional = transactionCategoryRepository.findById(transactionCategoryId);
        if(transactionCategoryOptional.isEmpty()){
            return null;
        }

        TransactionCategory updatedTransactionCategory = transactionCategoryOptional.get();
        updatedTransactionCategory.setCategoryName(newCategoryName);
        updatedTransactionCategory.setCategoryColor(newCategoryColor);
        return transactionCategoryRepository.save(updatedTransactionCategory);
    }

    // delete
    public boolean deleteTransactionCategoryById(int transactionCategoryId){
        logger.log(Level.INFO, "Deleting transaction category with id: {0}", transactionCategoryId);

        Optional<TransactionCategory> transactionCategoryOptional = transactionCategoryRepository.findById(transactionCategoryId);

        if(transactionCategoryOptional.isEmpty()) return false;

        transactionCategoryRepository.delete(transactionCategoryOptional.get());
        return true;
    }

}






