package tn.esprit.spring.service.Interface;

import java.util.List;

import tn.esprit.spring.entity.Contract;
import tn.esprit.spring.entity.ContractRequest;

public interface ContractRequestService {
	List<ContractRequest>retrieveALLContractsRequest();
	Contract addContractRequest(ContractRequest contract);
	void deleteContractRequest(int numRequest);
	Contract updateContractRequest(ContractRequest contract);
	Contract retrieveContractRequest(String ref_contrat);
	

}