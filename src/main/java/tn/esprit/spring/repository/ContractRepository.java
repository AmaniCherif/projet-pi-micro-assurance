package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Contract;

public interface ContractRepository  extends CrudRepository<Contract, Long>{

}
