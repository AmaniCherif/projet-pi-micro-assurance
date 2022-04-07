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

import tn.esprit.spring.entity.Contract;
import tn.esprit.spring.service.Implementation.ContractServiceImpl;
import tn.esprit.spring.service.Interface.ITableMortalitéService;

@RestController
@RequestMapping("/contracts")
public class ContractController {
	@Autowired
	ContractServiceImpl contractServiceImpl;

	@Autowired 
	ITableMortalitéService tr; 
	
	
	@GetMapping("/calculeContrat/{id}")
	public ResponseEntity<Contract> calculeContratController(@PathVariable("id") Long   id	){
				
		contractServiceImpl.tarificationContrat(id);
		return new ResponseEntity<Contract>(HttpStatus.OK);
	}
	@GetMapping("/")
	public List<Contract> getContracts() {			
		return contractServiceImpl.getContracts();
	}
	
	@PostMapping("/add")
	public Contract addContract(@RequestBody Contract contract){
		return contractServiceImpl.addContract(contract);
	}
	
	@PostMapping("/")
	public void inserttable(){
		 contractServiceImpl.insertTableMortal();
	}
	@PostMapping("/tablemortalite2")
	public void inserttable2(){
		 contractServiceImpl.insertTableMortal2();
	}
	
	@DeleteMapping("/{id}")  
	public void deleteContract(@PathVariable("id") Long id) {
		contractServiceImpl.deleteContract(id);
	}
	
	@PutMapping("/{id}")
	public Contract updateContract(@PathVariable("id") Long id, @RequestBody Contract newContract) {
		return contractServiceImpl.updateContract(id, newContract);
	}

	@GetMapping("/{id}")
	public Contract getContract(@PathVariable("id") Long id) {
		return contractServiceImpl.getContract(id);
	}

//	@GetMapping("/tarificationContrat/{id}")
//	public ResponseEntity<Contract> tarificationContratController(@PathVariable("ref_contrat") int id ){
//		System.out.println("haha");
//		csi.tarificationContrat(id);
//		System.out.println("nononon");
//		return new ResponseEntity<Contract>(HttpStatus.OK);
//	}
}
