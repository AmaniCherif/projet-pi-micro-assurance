package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import tn.esprit.spring.entity.Sinistre;


@Repository
public interface SinistreRepository extends CrudRepository<Sinistre, Integer>{

	/*List<Sinistre> findSinistreByState(State_Sinistre_Claim state_Sinistre_Claim);	
	List<Sinistre> findSinistreByState(State_Sinistre_Claim state_Sinistre_Claim);
	int findContractRequestDurationBySinistre(Integer id,ContractType str);
	List<Sinistre> findSinistresByStateReclamation();*/


}
