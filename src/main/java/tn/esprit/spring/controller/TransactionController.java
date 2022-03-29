package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Offer;
import tn.esprit.spring.entity.Transaction;

import tn.esprit.spring.service.Interface.TransactionService;
@RestController
public class TransactionController {
	@Autowired
	TransactionService transactionservice;
	
	@PostMapping("/addTransaction")
	@ResponseBody	
	public  Transaction addTransaction(@RequestBody Transaction t)
		{transactionservice.addTransaction(t);
		return t ;
		}
	@DeleteMapping("/deleteTransaction/{transactionid}")
	  public void deleteTransaction (@PathVariable("transactionid")int transactionid) {
		transactionservice.deleteTransaction(transactionid);
	  
	  }
	@GetMapping("/retrieveAllTransactions")

	  public List<Transaction> retrieveAllTransactions(){
		  return transactionservice.retrieveAllTransactions();
	  }
	@GetMapping("/retrieveTransactions/{transactionid}")
	  
	  public Transaction retrieveTransactions(@PathVariable("transactionid") int transactionid) {
		  return transactionservice.retrieveTransactions(transactionid);
	  }
	@PutMapping("/updateTransaction/{transactionid}")
	@ResponseBody
	public Transaction updateTransaction(@RequestBody Transaction t,@PathVariable("transactionid") int id ) {
		return transactionservice.updateTransaction(t,id);
	}

}
