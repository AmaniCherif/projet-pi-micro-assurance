package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Claims;
import tn.esprit.spring.entity.Ratingclaim;



public interface RatingclaimRepository extends CrudRepository<Ratingclaim, Long> {

}
