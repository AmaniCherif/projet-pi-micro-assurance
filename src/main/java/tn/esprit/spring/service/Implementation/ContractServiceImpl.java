package tn.esprit.spring.service.Implementation;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entity.Contract;
import tn.esprit.spring.repository.ContractRepository;
import tn.esprit.spring.service.Interface.ContractService;
@Service
public class ContractServiceImpl implements ContractService {
	@Autowired
	ContractRepository contractRep;

	@Override
	public List<Contract> retrieveALLContracts() {
		List<Contract> contract=(List<Contract>) (contractRep.findAll());
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contract addContract(Contract contract) {
		// TODO Auto-generated method stub
		contractRep.save(contract);
		return contract;
	}

	@Override
	public void deleteContract(String ref_contrat) {
		// TODO Auto-generated method stub
		contractRep.deleteById(ref_contrat);
		
		
	}

	@Override
	public Contract updateContract(Contract contract) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contract retrieveContract(String ref_contrat) {
		// TODO Auto-generated method stub
		//return null;
		return contractRep.findById(ref_contrat).get();
	}
	

}
