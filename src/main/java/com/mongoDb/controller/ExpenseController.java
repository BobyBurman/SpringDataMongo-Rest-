package com.mongoDb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongoDb.model.Expense;
import com.mongoDb.service.ExpenseService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/expense")
@Slf4j
public class ExpenseController {
	
	@Autowired
	private ExpenseService expenseServiceImpl;
	
	@PostMapping
	public ResponseEntity<?> addExpense(@RequestBody @Validated Expense expense) {
		
		Expense expense1=expenseServiceImpl.addExpense(expense);
		return new ResponseEntity<Expense>(expense1,HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateExpense(@RequestBody Expense expense) {
		System.out.println("expense----------->"+expense);
		return ResponseEntity.ok(expenseServiceImpl.updateExpense(expense));
	}
	
	@GetMapping
	public ResponseEntity<?> getAllExpense() {
		return  ResponseEntity.ok(expenseServiceImpl.getAllExpense());
		//return new ResponseEntity(expenseServiceImpl.getAllExpense(), HttpStatus.OK);

	}
	
	@GetMapping("/{name}")
	public ResponseEntity<?> getExpenseByName(@PathVariable(name="name", required = true) String name) {
		return new ResponseEntity<Expense>(expenseServiceImpl.getExpenseByName(name),HttpStatus.OK);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deleteExpense(@PathVariable(name="id", required = true) String id) {
		expenseServiceImpl.deleteExpense(id);
		return ResponseEntity.ok().build();
	}
}
