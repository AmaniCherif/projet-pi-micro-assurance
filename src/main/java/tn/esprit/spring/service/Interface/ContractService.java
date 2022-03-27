package tn.esprit.spring.service.Interface;

import java.util.List;

import tn.esprit.spring.entity.Contract;

public interface ContractService {
	List<Contract> getContracts();
	
	Contract addContract(Contract car);
	
	void deleteContract(Long id);
	
	Contract updateContract(Long id, Contract car);
	
	Contract getContract(Long id);
	
	void insertTableMortal();
	void insertTableMortal2();

}
