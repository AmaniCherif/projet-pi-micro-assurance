
package tn.esprit.spring.service.Implementation;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.ContractRequest;


import tn.esprit.spring.repository.ContractRepository;

import tn.esprit.spring.entity.ContractRequest;


import tn.esprit.spring.repository.ContractRequestRepository;
import tn.esprit.spring.service.Interface.ContractRequestService;

@Service
public class ContractRequestServiceImpl implements ContractRequestService {
	@Autowired
	ContractRequestRepository contractRequestRep;
	/*@Autowired
	UserRepository userRep;*/

	@Override
	// lister les demande Contrat
	public List<ContractRequest> retrieveALLContractsRequest() {
		List<ContractRequest> contractRequest = (List<ContractRequest>) contractRequestRep.findAll();
		// TODO Auto-generated method stub
		return contractRequest;
	}

	@Override
	@Transactional
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

	
	
	//verifer l etat de la demande contrat ( en cours ... )
//	@Transactional
//	public void verifeEtatContractRequest(int numRequest){
//		ContractRequest r = contractRequestRep.findById(numRequest).get();
//		if (r.getTraite()== 0) {
//			System.out.println("demande n'est pas traité");}
//		else {
//			System.out.println("demande traité");
//		}
//	}
	// lister les demande  Contrat en cours ( non traite )
	

	@Override
	public List<ContractRequest> IretreiveContratRequestTraite(int nb) {
		List<ContractRequest> contractRequestTraite = (List<ContractRequest>) contractRequestRep.IretreiveContratRequestTraite(nb);
		return contractRequestTraite;
	}


	@Override

	public ContractRequest retrieveContractRequest(int numRequest) {
		// TODO Auto-generated method stub
		return (ContractRequest) contractRequestRep.findById(numRequest).get();
	}

	/*@Transactional
	public void ajoutDemandeContrat(ContractRequest d , long id , String type , String nom){
		Date date = new Date();
		User u = userRep.findById(id).get();
		d.setDateRequest(date);
		d.setUser(u);
		d.setTypeContract(type);
		d.setTypeContract(nom);   
		ContractRequest.save(d);		
	}*/

}

