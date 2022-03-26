package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Contract;
@Repository
public interface ContractRepository  extends CrudRepository<Contract, String>{
	List<Contract> findByState(String state);
	List<Contract> findByAcceptReq(int acceptReq);
}
