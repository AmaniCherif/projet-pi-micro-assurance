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
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.spring.entity.ContractRequest;
import tn.esprit.spring.service.Implementation.ContractRequestServiceImpl;
@RestController
@RequestMapping("/ContractRequest")
public class ContractRequestController {
@Autowired
ContractRequestServiceImpl crsi;


@GetMapping("/getAllContractRequest")
public List<ContractRequest> getNomsContractRequestJPQL() {			
	return crsi.retrieveALLContractsRequest();
}
@PostMapping("/addContractRequest")
public ContractRequest addContractRequest(@RequestBody ContractRequest contractRequest)
	{crsi.addContractRequest(contractRequest);
	return contractRequest;
	}
@DeleteMapping("/deleteById/{numRequest}")  
public void deleteContractRequestById(@PathVariable("numReques")int numRequest) {
	crsi.deleteContractRequest(numRequest);
}
@PutMapping("/updateContractRequest")
public ContractRequest updateContractRequest(@RequestBody ContractRequest cr) {
	return crsi.updateContractRequest(cr);
}
@GetMapping("retrieve-contractRequest/{numRequest}")
public ContractRequest retrieveContractRequest(@PathVariable("numRequest") int numRequest) {
return crsi.retrieveContractRequest(numRequest);
} 

}
