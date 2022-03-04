package tn.esprit.spring.service.Interface;

import java.util.List;

import tn.esprit.spring.entity.Transaction;

public interface TransactionService {
	Transaction addTransaction(Transaction t);

	void deleteTransaction(int id);

	List<Transaction> retrieveAllTransactions();

	Transaction retrieveTransactions(int id);

	List<Transaction> listAll();
	
	List<Transaction> listTransactionByUserId(Long id) ;

    List<Transaction> listTransactionByDate(int annee);

	int addOrUpdateTransaction(Transaction t);
	public List<Transaction> getAllTransById();
	
}

