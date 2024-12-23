
package tn.esprit.spring.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entity.ContractRequest;


@Repository

public interface ContractRequestRepository extends CrudRepository<ContractRequest, Long>{


	
	@Query("SELECT c FROM ContractRequest c WHERE c.traite = :nb")
	public List<ContractRequest> IretreiveContratRequestTraite(@Param("nb") int nb);
	


	

}

