package tn.esprit.spring.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.ReinsuranceContract;

@Repository
public interface ReinsuranceContractRepository extends CrudRepository<ReinsuranceContract,Long>{
	@Query("SELECT COUNT(c) FROM Contract c where c.reassure=1")
	 List<Long> getReinc();
	List<ReinsuranceContract> findAll();
}
