package tn.esprit.spring.service.Interface;

import java.util.List;

import tn.esprit.spring.entity.Contract;

public interface ContractService {
	List<Contract>retrieveALLContracts();
	Contract addContract(Contract contract);
	void deleteContract(Long id);
	Contract updateContract(Contract contract);
	Contract retrieveContract(Long id);
	

}
