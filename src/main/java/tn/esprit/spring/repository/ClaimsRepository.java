package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Claims;

@Repository
public interface ClaimsRepository extends CrudRepository<Claims,Long> {

}
