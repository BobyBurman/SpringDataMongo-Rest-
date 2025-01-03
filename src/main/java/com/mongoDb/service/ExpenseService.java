package com.mongoDb.service;

import java.util.List;

import com.mongoDb.model.Expense;

public interface ExpenseService {
	
	public Expense addExpense(Expense expense);

	public List<Expense> getAllExpense();

	public void deleteExpense(String id);

	public Expense updateExpense(Expense expense);

	public Expense getExpenseByName(String name);

}
