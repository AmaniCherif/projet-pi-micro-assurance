package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Provision;
@Repository
public interface ProvisionsRepository extends CrudRepository<Provision, Integer>{

}
