package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.ContractRequest;
import tn.esprit.spring.entity.Typesante;



@Repository
public interface TypesanteRepo extends JpaRepository<Typesante, Long> {

	Typesante findByContractRequest(ContractRequest id);
	
	
}
