package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.ContractOffer;

public interface ContractOfferRepository extends CrudRepository<ContractOffer, Integer>{
	@Query("select c from ContractOffer c where c.users.idUser=:idUser")
	public ContractOffer Contract_OffersByUser(@Param ("idUser")int idUser );
}
