package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Claims;



public interface ClaimsRepository extends CrudRepository<Claims, Long> {

}
