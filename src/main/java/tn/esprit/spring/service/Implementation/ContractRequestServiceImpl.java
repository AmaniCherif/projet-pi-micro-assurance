
package tn.esprit.spring.service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Contract;
import tn.esprit.spring.entity.ContractRequest;

import tn.esprit.spring.repository.ContractRepository;

import tn.esprit.spring.repository.ContractRequestRepository;
import tn.esprit.spring.service.Interface.ContractRequestService;

@Service
public class ContractRequestServiceImpl implements ContractRequestService {
	@Autowired
	ContractRequestRepository contractRequestRep;

	@Override
	public List<ContractRequest> retrieveALLContractsRequest() {
		List<ContractRequest> contractRequest = (List<ContractRequest>) contractRequestRep.findAll();
		// TODO Auto-generated method stub
		return contractRequest;
	}

	@Override
	public ContractRequest addContractRequest(ContractRequest cr) {
		// TODO Auto-generated method stub
		contractRequestRep.save(cr);
		return cr;
	}


	@Override
	public void deleteContractRequest(int numRequest) {
		// TODO Auto-generated method stub
		contractRequestRep.deleteById(numRequest);
	}

	@Override
	public ContractRequest updateContractRequest(ContractRequest cr) {
		return null;
	}

	@Override

	public ContractRequest retrieveContractRequest(int numRequest) {
		// TODO Auto-generated method stub
		return (ContractRequest) contractRequestRep.findById(numRequest).get();
	}

	
	

}

