package tn.esprit.spring.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.DocumentException;

import tn.esprit.spring.entity.Transaction;
import tn.esprit.spring.service.Interface.TransactionService;
import tn.esprit.spring.service.Interface.PaymentPdf;

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
	@GetMapping("/listTransactionByContractId/{id}")
	
	  public List<Transaction> listTransactionByContractId(@PathVariable("id") long id) {
		  return transactionservice.listTransactionByContractId(id);
	  }
	
	@GetMapping("/listAllAsd")
	
	public List<Transaction> listAllAsd() {
		  return transactionservice.listAllAsd();
	  }
	@GetMapping("/listTransactionByDate/{annee}")
	
	  public List<Transaction> listTransactionByDate(@PathVariable("annee") int annee) {
		  return transactionservice.listTransactionByDate(annee);
	  }
	
	@GetMapping("/StatisticMonthbyAmount/{year}")
	
	public Map<Double, Double> StatisticMonthbyAmount(@PathVariable("year") int year) {
		  return transactionservice.StatisticMonthbyAmount(year);
	  }
	
	@PutMapping("/affecterPaymentToContract/{Transaction_ID}/{Contract_ID}")
	@ResponseBody
	public void affecterPaymentToContract(@PathVariable("Transaction_ID") int idp,@PathVariable("Contract_ID") int id) {
		transactionservice.affecterPaymentToContract(idp, id);
	}
	@GetMapping("/amine/Hana/pdf")
	public void PaymentPdf(HttpServletResponse response) throws DocumentException, IOException {
	    response.setContentType("application/pdf");
	    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	    String currentDateTime = dateFormatter.format(new Date());
	     
	    String headerKey = "Content-Disposition";
	    String headerValue = "attachment; filename=payments" + currentDateTime + ".pdf";
	    response.setHeader(headerKey, headerValue);
	     
	    List<Transaction> listPayment = transactionservice.retrieveAllTransactions();
	     
	    PaymentPdf exporter = new PaymentPdf(listPayment);
	    exporter.export(response);
	     
	    
	}
}
