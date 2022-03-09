package tn.esprit.spring.service.Interface;

import java.util.List;

import tn.esprit.spring.entity.ReinsuranceContract;

public interface ReinsuranceContractService {

	List<ReinsuranceContract>retrieveALLContracts();
	ReinsuranceContract addReinsuranceContract(ReinsuranceContract reinCont);
	void deleteReinsuranceContract(int account_id);
	ReinsuranceContract updateReinsuranceContract(ReinsuranceContract reinCont);
	ReinsuranceContract retrieveReinsuranceContract(int account_id);
}
