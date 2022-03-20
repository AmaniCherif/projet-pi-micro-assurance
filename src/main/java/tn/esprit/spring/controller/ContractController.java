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

@RestController
@RequestMapping("/Contract")
public class ContractController {
	@Autowired
	ContractServiceImpl csi;
	//URL : http://localhost:8080/SpringMVC/Contract/getAllContract
	@GetMapping("/getAllContract")
	public List<Contract> getNomsContractJPQL() {			
		return csi.retrieveALLContracts();
	}
	@PostMapping("/addContract")
	public Contract addContract(@RequestBody Contract contract)
			
		{csi.addContract(contract);
		return contract;
		}
	@DeleteMapping("/deleteById/{ref_contrat}")  
	public void deleteContractById(@PathVariable("ref_contrat") int ref_contrat) {
		csi.deleteContract(ref_contrat);
	}
	@PutMapping("/updateContract")
	public Contract updateContract(@RequestBody Contract c) {
		return csi.updateContract(c);
	}

	@GetMapping("retrieve-contract/{ref_contrat}")
	public Contract retrieveContract(@PathVariable("ref_contrat") int ref_contrat) {
		return csi.retrieveContract(ref_contrat);
	}

	@GetMapping("/tarificationContrat/{id}")
	public ResponseEntity<Contract> tarificationContratController(@PathVariable("id") int id ){
		System.out.println("haha");
		csi.tarificationContrat(id);
		System.out.println("nononon");
		return new ResponseEntity<Contract>(HttpStatus.OK);
	}
}
