package tn.esprit.spring.service.Interface;

import java.util.List;

import tn.esprit.spring.entity.Transaction;

public interface TransactionService {
	Transaction addTransaction(Transaction trans);

	void deleteTransaction(int id);

	List<Transaction> retrieveAllTransactions();

	Transaction retrieveTransactions(int id);
	
    Transaction updateTransaction(Transaction t , int id);

	List<Transaction> listAllAsd();
	
	List<Transaction> listTransactionByUserId(Long id) ;

    List<Transaction> listTransactionByDate(int annee);

	int addOrUpdateTransaction(Transaction t);
	public List<Transaction> getAllTransById();
	
} 

