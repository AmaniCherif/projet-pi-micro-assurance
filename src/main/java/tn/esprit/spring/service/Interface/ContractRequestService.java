package tn.esprit.spring.service.Interface;

import java.util.List;

import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.ContractRequest;

public interface ContractRequestService {
	List<ContractRequest>retrieveALLContractsRequest();
	ContractRequest addContractRequest(ContractRequest cr);
	void deleteContractRequest(Long id);
	ContractRequest updateContractRequest(ContractRequest cr);
	ContractRequest retrieveContractRequest(Long id);
	List<ContractRequest> IretreiveContratRequestTraite(@Param("nb") int nb);


		
		
	}
	

