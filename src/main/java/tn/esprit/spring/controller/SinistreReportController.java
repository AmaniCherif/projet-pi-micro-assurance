package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.spring.entity.SinistreReport;
import tn.esprit.spring.service.Implementation.SinistreReportServiceImpl;

@RestController
@RequestMapping("/SinistreReport")
public class SinistreReportController {

	@Autowired
	SinistreReportServiceImpl srsi;
	
	@GetMapping("/calculeContrat/{id}")
	public ResponseEntity<SinistreReport> CalculPartialBuybackController(@PathVariable("idSinistreReport") int   idSinistreReport	){
				
		srsi.CalculPartialBuyback(idSinistreReport);
		return new ResponseEntity<SinistreReport>(HttpStatus.OK);
	}
	
	@GetMapping("/calculeContrat/{id1}")
	public ResponseEntity<SinistreReport> CalculTotalBuybackController(@PathVariable("idSinistreReport") int   idSinistreReport	){
				
		srsi.CalculTotalBuyBack(idSinistreReport);
		return new ResponseEntity<SinistreReport>(HttpStatus.OK);
	}
	@PostMapping("/addSinistrereport")
	public SinistreReport addSinistreReport(@RequestBody SinistreReport sinistreReport) {
		srsi.addSinistreReport(sinistreReport);
		return sinistreReport;
	}
	
	@GetMapping("/getALLSinistreReport")
	public List<SinistreReport> getALLSinistreReport(){
		return srsi.retrieveALLSinistreReport();
	}
	
	@DeleteMapping("/deletebyid/{idSinistreReport}")
	public void deleteSinistreReportById(@PathVariable ("idSinistreReport") int idSinistreReport) {
		srsi.deleteSinistreReport(idSinistreReport);
	}
	
	@PutMapping("/updateSinistreReport")
	public SinistreReport updateSinistreReport(@RequestBody SinistreReport sinistreReport) {
		return srsi.updateSinistreReport(sinistreReport);
	}
	
	@GetMapping("/getSinistreReport/{idSinistreReport}")
	public SinistreReport getSinistreReport(@PathVariable ("idSinistreReport") int idSinistreReport) {
		return srsi.retrieveSinistreReport(idSinistreReport);
	}
	
	
}




