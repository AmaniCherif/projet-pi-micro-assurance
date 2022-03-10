package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import tn.esprit.spring.entity.Transaction;
import tn.esprit.spring.service.Interface.TransactionService;

public class TransactionController {
	@Autowired
	TransactionService transactionservice;
	@ResponseBody
	public void addTransaction(@RequestBody Transaction t) {
		transactionservice.addTransaction(t);
	}
}
