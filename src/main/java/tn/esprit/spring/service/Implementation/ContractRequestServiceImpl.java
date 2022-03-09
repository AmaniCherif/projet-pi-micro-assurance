package tn.esprit.spring.service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Contract;
import tn.esprit.spring.entity.ContractRequest;
import tn.esprit.spring.repository.ContractRequestRepository;
import tn.esprit.spring.service.Interface.ContractRequestService;

@Service
public class ContractRequestServiceImpl implements ContractRequestService {
	@Autowired
	ContractRequestRepository crr;

	@Override
	public List<ContractRequest> retrieveALLContractsRequest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contract addContractRequest(ContractRequest contract) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteContractRequest(int numRequest) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Contract updateContractRequest(ContractRequest contract) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contract retrieveContractRequest(String ref_contrat) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
