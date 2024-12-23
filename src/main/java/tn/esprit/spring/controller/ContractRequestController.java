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


import tn.esprit.spring.entity.ContractRequest;


import tn.esprit.spring.service.Interface.ContractRequestService;

@RestController
@RequestMapping("/ContractRequest")
public class ContractRequestController {

	@Autowired
	ContractRequestService crsi;
	
	@GetMapping("/getAllContractRequest")
	
	public List<ContractRequest> getNomsContractRequestJPQL() {			
		return crsi.retrieveALLContractsRequest();
	}

	@PostMapping("/addContractRequest")
	public ContractRequest addContractRequest(@RequestBody ContractRequest contractRequest){
		crsi.addContractRequest(contractRequest);
		return contractRequest;
	}

	@DeleteMapping("/deleteById/{id}")  
	public void deleteContractRequestById(@PathVariable("id")Long id) {
		crsi.deleteContractRequest(id);
	}

	@PutMapping("/updateContractRequest")
	public ContractRequest updateContractRequest(@RequestBody ContractRequest cr) {
		return crsi.updateContractRequest(cr);
	}

	@GetMapping("retrieve-contractRequest/{id}")
	public ContractRequest retrieveContractRequest(@PathVariable("id") Long id) {
		return crsi.retrieveContractRequest(id);
	}
	

	/*@GetMapping("/liste/{nb}")
	//@ResponseBody
	public List<ContractRequest> afficheContractRequestTraiteController(@PathVariable("nb") int nb){
		List<ContractRequest> list = crsi.IretreiveContratRequestTraite(nb);
		return list;		
	}*/
	
	
}
