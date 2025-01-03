package com.mongoDb.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.mongoDb.model.Expense;
import com.mongoDb.repository.ExpenseRepository;
import com.mongoDb.service.ExpenseService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ExpenseServiceImpl implements ExpenseService{
	
	@Autowired
	private ExpenseRepository expenseRepository;

	@Override
	public Expense addExpense(Expense expense) {

		return expenseRepository.insert(expense);

	}

	@Override
	public Expense updateExpense(Expense expense) {
		log.info("Updated Expense: " + expense.getId());
			Expense savedExpense=expenseRepository.findById(expense.getId())
					.orElseThrow(()->new RuntimeException(
							String.format("connot find Expense by ID %s",expense.getId())));
			
			savedExpense.setExpenseName(expense.getExpenseName());
			savedExpense.setExpenseCategory(expense.getExpenseCategory());
			savedExpense.setExpenseAmount(expense.getExpenseAmount());
			log.info("Updated Expense: " + savedExpense);
			return expenseRepository.save(savedExpense);
			
					
	}

	@Override
	public List<Expense> getAllExpense() {
		return expenseRepository.findAll();
		
	}

	@Override
	public Expense getExpenseByName(String name) {
		return expenseRepository.findByName(name).orElseThrow(()->new RuntimeException(
				String.format("connot find Expense by name %s",name)));
		
	}

	@Override
	public void deleteExpense(String id) {
		log.info("id--->"+id);
		Expense savedExpense=expenseRepository.findById(id)
				.orElseThrow(()->new RuntimeException(
						String.format("connot find Expense by ID %s",id)));
		log.info("iddddd--->"+id);
		expenseRepository.deleteById(id);
	}


}
