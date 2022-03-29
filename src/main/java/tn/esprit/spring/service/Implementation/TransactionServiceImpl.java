package tn.esprit.spring.service.Implementation;

import java.util.List;
import java.util.Optional;
import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

import tn.esprit.spring.entity.Transaction;
import tn.esprit.spring.repository.TransactionRepository;
import tn.esprit.spring.service.Interface.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService{
	@Autowired
	TransactionRepository transactionRepository;
	@Override
	public Transaction addTransaction(Transaction t) {
		transactionRepository.save(t);
		
		return t;
	}

	@Override
	public void deleteTransaction(int id) {
		transactionRepository.deleteById(id);		
	}

	@Override
	public List<Transaction> retrieveAllTransactions() {
		
		
		List<Transaction> listTransaction =(List<Transaction>) transactionRepository.findAll();
				return listTransaction;
		 
	}

	@Override
	public List<Transaction> listAllAsd() {
		return null;
	}
	
	@Override
	public Transaction retrieveTransactions(int id) {
		Optional<Transaction> TransOptional = transactionRepository.findById(id);
		Transaction t = TransOptional.get();
		return t;
	}
	@Override
	public int addOrUpdateTransaction(Transaction t) {
		
		transactionRepository.save(t);
		return t.getTransactionid();
	}

	

	@Override
	public List<Transaction> listTransactionByUserId(Long id) {
		return null;
	}

	@Override
	public List<Transaction> listTransactionByDate(int annee) {
		return null;
	}

	

	@Override
	public List<Transaction> getAllTransById() {
		return null;
	}

	

	@Override
	public Transaction updateTransaction(Transaction t, int id) {
		Transaction transactionUptaded =transactionRepository.findById(id).get();
		transactionUptaded.setTransactionAmount(t.getTransactionAmount());
		transactionUptaded.setTransactionDate(t.getTransactionDate());
		//transactionUptaded.setTypeTransaction(t.getTypeTransaction());
		transactionRepository.save(transactionUptaded);
		return transactionUptaded;
	}

	

}
