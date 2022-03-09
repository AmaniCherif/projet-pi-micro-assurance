package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account,Integer>{

}
