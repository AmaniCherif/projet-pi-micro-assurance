package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Transaction;

@Repository
	public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

	//@Query("select c from Transaction c where c.transactionAmount = '3L'  ")
  //  List<Transaction> findAllByIdTran();
	

	}

