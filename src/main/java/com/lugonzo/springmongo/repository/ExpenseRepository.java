package com.lugonzo.springmongo.repository;

import com.lugonzo.springmongo.model.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExpenseRepository extends MongoRepository<Expense,String> {

    @Query("{'name': ?0 }")
    Optional<Expense> findByName(String name);
}
