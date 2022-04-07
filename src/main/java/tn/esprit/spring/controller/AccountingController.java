package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.entity.Accounting;
import tn.esprit.spring.service.Interface.AccountingService;

@RestController
@RequestMapping("/accounting")
public class AccountingController {
	@Autowired
	AccountingService accountingService;
	
	
	@GetMapping("/accountings")
	@ResponseBody
	public List<Accounting> getAccountings() {
	List<Accounting> list = accountingService.retrieveAllAccountings();
	return list;
	}
	@GetMapping("/retrieveAccounting/{AccountingId}")
	@ResponseBody
	public Accounting retrieveAccounting(@PathVariable("AccountingId") String Id) {
	return accountingService.retrieveAccounting(Id);
	}
	
	
	@PostMapping("/addAccounting")
	@ResponseBody
	public Accounting addAccounting(@RequestBody Accounting s) {
	Accounting accounting = accountingService.addAccounting(s);
	accountingService.assets();
	accountingService.liabilities();
	accountingService.exercise_result();
	return accounting;
	}
	
	@DeleteMapping("/removeAccounting/{accounting_id}")
	@ResponseBody
	public void removeAccounting(@PathVariable("accounting_id") String accounting_id) {
		accountingService.deleteAccounting(accounting_id);
	}
	
	@PutMapping("/updateAccounting")
	@ResponseBody
	public Accounting updateAccounting(@RequestBody Accounting accounting) {
	return accountingService.updateAccounting(accounting);
	}
	

	@PutMapping("/affecterAccountingToUser/{accounting_id}/{id_user}")
	@ResponseBody
	public void affecterAccountingToUser(@PathVariable("accounting_id") int idp,@PathVariable("id_user") Long id) {
		accountingService.affecterAccountingToUser(idp, id);
	}
	@GetMapping("/prime")
	@ResponseBody
	public float calculerPrime(){
		return accountingService.totalPrimeCom();
		
	}
	@GetMapping("/frais")
	@ResponseBody
	public float calculerFrais(){
		return accountingService.totalFrais();
	}
	
	@GetMapping("/reinsuranceQP")
	@ResponseBody
	public float calculerReinsuranceQP(){
		return accountingService.ReinsuranceComm();
	}
	
	@GetMapping("/resultat")
	@ResponseBody
	public String Resultat(){
		return accountingService.Resultat();
	}
	@GetMapping("/assets")
	@ResponseBody
	public float assets(){
		return accountingService.assets();
	}
	@GetMapping("/liabilities")
	@ResponseBody
	public float liabilities(){
		return accountingService.liabilities();
	}
	
}
