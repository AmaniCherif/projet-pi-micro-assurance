package tn.esprit.spring.service.Interface;

import java.util.List;

import tn.esprit.spring.entity.ReinsuranceContract;
//import tn.esprit.spring.entity.User;

public interface ReinsuranceContractService {

	List<ReinsuranceContract>retrieveALLContracts();
	ReinsuranceContract addReinsuranceContract(ReinsuranceContract reinCont);
	void deleteReinsuranceContract(Long id);
	ReinsuranceContract updateReinsuranceContract(ReinsuranceContract reinCont);
	ReinsuranceContract retrieveReinsuranceContract(Long id);
	 void deleteReinOffers(Long id);
	/* String ReinSinistre();
	 List<Long> getContrar();
	 List<Long> getReinr();*/
}
