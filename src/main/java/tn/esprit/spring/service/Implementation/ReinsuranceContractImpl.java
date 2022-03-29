package tn.esprit.spring.service.Implementation;

import java.util.Date;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Contract;
import tn.esprit.spring.entity.ContractRequest;
import tn.esprit.spring.entity.ReinsuranceContract;
import tn.esprit.spring.entity.Sinistre;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.ReinsuranceContractRepository;
import tn.esprit.spring.service.Interface.ReinsuranceContractService;


@Service
public class ReinsuranceContractImpl implements ReinsuranceContractService {

	@Autowired
	ReinsuranceContractRepository reinsuranceRepository;
	
	
	private static final Logger l = LogManager.getLogger(ReinsuranceContractService.class);

	@Override
	public List<ReinsuranceContract>retrieveALLContracts(){
		List<ReinsuranceContract> reins =  (List<ReinsuranceContract>) reinsuranceRepository.findAll();
		for(ReinsuranceContract rein : reins)
		{
			l.info("user ++ :"+rein);
		}
		return reins;
	}
	@Override
	public ReinsuranceContract addReinsuranceContract(ReinsuranceContract reinCont) {
		ReinsuranceContract reinSaved = null;
		reinSaved=reinsuranceRepository.save(reinCont);
		return reinSaved;
	}
	@Override
	public void deleteReinsuranceContract(Long id) {
		
		reinsuranceRepository.deleteById(id);
	}
	
	@Override
	public ReinsuranceContract updateReinsuranceContract(ReinsuranceContract reinCont) {
		ReinsuranceContract reinAdded = reinsuranceRepository.save(reinCont);
		return reinAdded;
		
	}
	@Override
	public ReinsuranceContract retrieveReinsuranceContract(Long id) {
		ReinsuranceContract r = reinsuranceRepository.findById(id).get();
		return r;
	}
	@Override
	public void deleteReinOffers(Long id) {
		reinsuranceRepository.deleteById(id);
		
	}
}
