package com.lugonzo.springmongo.service;

import com.lugonzo.springmongo.model.Expense;
import com.lugonzo.springmongo.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public void addExpense(Expense expense) {
        expenseRepository.insert(expense);
    }

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public void updateExpense(Expense expense) {
        Expense savedExpense = expenseRepository.findById(expense.getId())
                .orElseThrow(()-> new RuntimeException((
                        String.format("Cannot find expense by ID %s",expense.getId())
                        )));

        savedExpense.setExpenseAmount(expense.getExpenseAmount());
        savedExpense.setExpenseName(expense.getExpenseName());
        savedExpense.setExpenseCategory(expense.getExpenseCategory());

        expenseRepository.save(expense);
    }

    public Expense getExpenseByName(String expenseName) {
        return expenseRepository.findByName(expenseName).orElseThrow(()-> new RuntimeException((
                String.format("Cannot find expense by name -> %s",expenseName)
                )));
    }

    public void deleteExpense(String expenseId) {
        expenseRepository.deleteById(expenseId);
    }
}
