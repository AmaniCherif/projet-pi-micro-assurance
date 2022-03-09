package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.ContractOffer;
@Repository
public interface ContractOfferRepository extends CrudRepository<ContractOffer, String> {

}
