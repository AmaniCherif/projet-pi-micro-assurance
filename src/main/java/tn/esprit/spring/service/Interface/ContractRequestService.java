package tn.esprit.spring.service.Interface;

import java.util.List;

import tn.esprit.spring.entity.Contract;
import tn.esprit.spring.entity.ContractRequest;

public interface ContractRequestService {
	List<ContractRequest>retrieveALLContractsRequest();
	ContractRequest addContractRequest(ContractRequest cr);
	void deleteContractRequest(int numRequest);
	ContractRequest updateContractRequest(ContractRequest cr);
	ContractRequest retrieveContractRequest(int numRequest);
	

}


