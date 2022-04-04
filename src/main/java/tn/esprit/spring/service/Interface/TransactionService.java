package tn.esprit.spring.service.Interface;

import java.util.List;
import java.util.Map;

import tn.esprit.spring.entity.Transaction;

public interface TransactionService {
	Transaction addTransaction(Transaction trans);

	void deleteTransaction(int id);

	List<Transaction> retrieveAllTransactions();

	Transaction retrieveTransactions(int id);
	
    Transaction updateTransaction(Transaction t , int id);

	List<Transaction> listAllAsd();
	public List<Transaction> listTransactionByContractId(long id);
	//List<Transaction> Transaction(long id) ;

    List<Transaction> listTransactionByDate(int annee);
 
    public void affecterPaymentToContract(int idt, long id);
    
	int addOrUpdateTransaction(Transaction t);
	public List<Transaction> getAllTransById();
	public Map<Double, Double> StatisticMonthbyAmount(int year);
} 

