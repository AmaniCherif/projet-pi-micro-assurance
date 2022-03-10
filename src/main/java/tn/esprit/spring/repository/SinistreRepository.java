package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Sinistre;
import tn.esprit.spring.entity.State_Sinistre_Claim;

public interface SinistreRepository extends CrudRepository<Sinistre, Integer>{

	List<Sinistre> findSinistreByState(State_Sinistre_Claim state_Sinistre_Claim);

}
