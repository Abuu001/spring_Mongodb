package com.lugonzo.springmongo.controller;

import com.lugonzo.springmongo.model.Expense;
import com.lugonzo.springmongo.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/expense")
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;

    @PostMapping
    public ResponseEntity addExpense(@RequestBody Expense newExpense){
        expenseService.addExpense(newExpense);
        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<Expense> updateExpense(@RequestBody Expense expense){
        expenseService.updateExpense(expense);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpenses(){
        return ResponseEntity.ok(expenseService.getAllExpenses());
    }

    @GetMapping("/{expenseName}")
    public ResponseEntity<Expense> getExpenseByName(@PathVariable("expenseName") String expenseName){
      return ResponseEntity.ok(expenseService.getExpenseByName(expenseName));
    }

    @DeleteMapping("/{expenseId}")
    public ResponseEntity deleteExpense(@PathVariable("expenseId") String expenseId){
        expenseService.deleteExpense(expenseId);
        return ResponseEntity.noContent().build();
    }
}
