package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.ReinsuranceContract;
@Repository
public interface ReinsuranceContractRepository extends CrudRepository<ReinsuranceContract,Long>{

}
