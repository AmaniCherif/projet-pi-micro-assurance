package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Provisions;
@Repository
public interface ProvisionsRepository extends CrudRepository<Provisions, Integer>{

}
