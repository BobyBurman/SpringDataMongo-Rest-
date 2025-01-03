package com.mongoDb.repository;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.mongoDb.model.Expense;

@Repository
public interface ExpenseRepository extends MongoRepository<Expense,String>{
	
	
	@SuppressWarnings("unchecked")
	Expense insert(Expense expense);
	
	Optional<Expense> findById(String id);

	@SuppressWarnings("unchecked")
	Expense save(Expense savedExpense);
	
	@Query("{'name': ?0}")
	Optional<Expense> findByName(String name);
	
	void deleteById(String id);
}
