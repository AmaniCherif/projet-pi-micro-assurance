package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.ContractRequest;



@Repository
public interface ContractRequestRepository extends CrudRepository<ContractRequest, String>{
}
