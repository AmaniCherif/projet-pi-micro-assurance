package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Sinistre;




@Repository
public interface SinistreRepository extends CrudRepository<Sinistre, Integer>{


}
